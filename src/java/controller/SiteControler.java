package controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Orders;
import model.OrdersDao;
import model.Product;
import model.ProductDao;
import model.Type;
import model.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteControler {
    
    @Autowired
    TypeDao typeDao;
    
    @Autowired
    ProductDao productDao;
    
    @Autowired
    OrdersDao ordersDao;
    
    @RequestMapping("/")
    public String index(ModelMap model, @RequestParam(defaultValue = "1") Integer page){
        List<Type> types = typeDao.find();
        List<Product> products = productDao.findByPage(page-1);
        model.addAttribute("products",products);
        model.addAttribute("types",types);
        model.addAttribute("allpages",productDao.pages());
        return "index";
    }
    
    @RequestMapping("/{id}")
    public String byType(@PathVariable int id, ModelMap model){
        List<Type> types = typeDao.find();
        List<Product> products = productDao.findByType(id);
        model.addAttribute("types",types);
        model.addAttribute("products",products);
        return "index";
    }
    
    @RequestMapping("/tocart/{id}")
    public String toCart(@PathVariable int id, ModelMap model){
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        Product product = productDao.getById(id);
        model.addAttribute("product",product);
        return "tocart";
    }
    
    @RequestMapping("/addtocart")
    public String addToCart(ModelMap model,
                            HttpServletRequest request,
                            @RequestParam(required = true) Integer id,
                            @RequestParam(required = true) Integer quantity,
                            @RequestParam(required = true) String size){
        
        HttpSession session = request.getSession();
        HashMap<Integer,Product> cart;
        if(session.getAttribute("cart")==null){
            session.setAttribute("cart", new HashMap<>());
        }
        cart = (HashMap<Integer,Product>)session.getAttribute("cart");
        if(!cart.containsKey(id)){
            Product product = productDao.getById(id);
            product.quantity = quantity;
            product.size = size;
            cart.put(id, product);
        }else{
            Product productFromCart = cart.get(id);
            productFromCart.quantity+=quantity;
            productFromCart.size = size;
        }
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        return "addedtocart";
    }
    
    @RequestMapping("/cart")
    public String cart(ModelMap model, HttpServletRequest request){
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        List<Product> products = new ArrayList<>();
        HttpSession session = request.getSession();
        
        if(session.getAttribute("cart")!=null){
            HashMap<Integer,Product> sessionProducts = (HashMap<Integer,Product>)session.getAttribute("cart");
            for(Map.Entry<Integer,Product> p : sessionProducts.entrySet()){
                products.add(p.getValue());
            }
        }
        model.addAttribute("products",products);
        return "cart";
    }
    
    @RequestMapping("/remove")
    public String remove(@RequestParam(required = true) int id, HttpServletRequest request, ModelMap model){
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        
        HttpSession session = request.getSession();
        if(session.getAttribute("cart")!=null){
            HashMap<Integer,Product> products = (HashMap<Integer,Product>)session.getAttribute("cart");
            if(products.containsKey(id)){
                products.remove(id);
            }
        }
        return "remove";
    }
    
    @RequestMapping("/confirm")
    public String confirmOrder(ModelMap model, HttpServletRequest request, @RequestParam(required = false) String userdata){
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        
        if(userdata == null){
            
        }else{
            HttpSession session = request.getSession();
            StringBuilder sb = new StringBuilder();
            HashMap<Integer,Product> sessionProducts = (HashMap<Integer,Product>)session.getAttribute("cart");
            sb.append("[");
            for(Map.Entry<Integer,Product> p : sessionProducts.entrySet()){
                sb.append("{\"id\":");
                sb.append(p.getValue().getId());
                sb.append(",\"q\":");
                sb.append(p.getValue().getQuantity());
                sb.append(",\"s\":");
                sb.append(p.getValue().getSize());
                sb.append("},");
            }
            String substr = sb.substring(0,sb.length()-1);
            substr += "]";
            Orders order = new Orders();
            order.setArticles(substr);
            order.setOrdertime(new Date(new java.util.Date().getTime()));
            order.setUserdata(userdata);
            ordersDao.save(order);
            session.removeAttribute("cart");
            return "successvalidate";
        }
        return "confirm";
    }

    @RequestMapping("/contactus")
    public String contactUs(ModelMap model){
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        return "contactus";
    }
        
}
