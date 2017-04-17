package controller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Orders;
import model.OrdersDao;
import model.Product;
import model.ProductDao;
import model.Type;
import model.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminControler {
    
    @Autowired
    TypeDao typeDao;
    
    @Autowired
    ProductDao productDao;
    
    @Autowired
    OrdersDao ordersDao;
    
    @RequestMapping("/")
    public String index(){
        return "admin/index";
    }
    
    @RequestMapping("/types")
    public String types(ModelMap model, @RequestParam(required = false) Integer id){
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        if(id!=null){
            Type selectedType = typeDao.getById(id);
            model.addAttribute("selectedType", selectedType);
        }
        return "admin/types";
    }
    
    @RequestMapping("/updatetype")
    public String updateType(ModelMap model, @RequestParam Integer id, @RequestParam String name){
        Type selectedType = typeDao.getById(id);
        selectedType.setName(name);
        typeDao.update(selectedType);
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        model.addAttribute("selectedType", selectedType);
        return "admin/types";
    }
    
    @RequestMapping("/articles")
    public String articles(@RequestParam(defaultValue = "1") Integer page, ModelMap model){
        List<Product> products = productDao.findByPage(page-1);
        model.addAttribute("products",products);
        model.addAttribute("allpages", productDao.pages());
        return "admin/articles";
    }
    
    @RequestMapping("/updatearticle")
    public String updateProduct(ModelMap model, @RequestParam Integer id){
        Product product = productDao.getById(id);
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        model.addAttribute("product",product);
        return "admin/updatearticle";
    }
    
    @RequestMapping(value = "/updatearticle", method = RequestMethod.POST)
    public String updateProductPost(ModelMap model,
                                    @RequestParam Integer id,
                                    @RequestParam String brand,
                                    @RequestParam String price,
                                    @RequestParam Integer type,
                                    @RequestParam MultipartFile photo,
                                    HttpServletRequest request) throws FileNotFoundException, IOException{
        Product product = productDao.getById(id);
        product.setBrand(brand);
        product.setPrice(new BigDecimal(price));
        product.setType(type);
        if(photo!=null && !photo.isEmpty()){
            String filePath = request.getServletContext().getRealPath("resources/images");
            FileOutputStream fos = new FileOutputStream(filePath+"/"+photo.getOriginalFilename());
            fos.write(photo.getBytes());
            fos.close();
            product.setPhoto(photo.getOriginalFilename());
        }
        productDao.update(product);
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        model.addAttribute("product",product);
        return "admin/updatearticle";
    }
    @RequestMapping("/addNewType")
    public String addNewType(ModelMap model, @RequestParam String name){
        Type newType = new Type();
        newType.setName(name);
        typeDao.addType(newType);
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        return "admin/types";
    }
    
    @RequestMapping("/deleteType")
    public String deleteType(ModelMap model, @RequestParam Integer id){
        Type type = typeDao.getById(id);
        typeDao.deleteType(type);
        List<Type> types = typeDao.find();
        model.addAttribute("types",types);
        return "admin/types";
    }
    
    @RequestMapping("addNewArticle")
    public String addNewArticle(@RequestParam String brand,
                                @RequestParam String price,
                                @RequestParam Integer type,
                                HttpServletRequest request,
                                @RequestParam MultipartFile photo) throws FileNotFoundException, IOException{
        Product newProduct = new Product();
        newProduct.setBrand(brand);
        newProduct.setPrice(new BigDecimal(price));
        newProduct.setType(type);
        String path = request.getServletContext().getRealPath("resources/images");
        FileOutputStream fos = new FileOutputStream(path+"/"+photo.getOriginalFilename());
        fos.write(photo.getBytes());
        fos.close();
        newProduct.setPhoto(photo.getOriginalFilename());
        productDao.addProduct(newProduct);
        return "admin/updatearticle";
    }
     @RequestMapping("/deleteArticle")
    public String deleteArticle(@RequestParam Integer id){
        Product product = productDao.getById(id);
        productDao.deleteProduct(product);
        return "admin/updatearticle";
    }
    
    @RequestMapping("/orders")
    public String orders(ModelMap model){
        List<Orders> orders = ordersDao.find();
        model.addAttribute("orders",orders);
        return "admin/orders";
    }
    
    @RequestMapping("/deleteOrder")
    public String deleteOrders(@RequestParam Integer id, ModelMap model){
        Orders order = ordersDao.getById(id);
        ordersDao.delete(order);
        List<Orders> orders = ordersDao.find();
        model.addAttribute("orders",orders);
        return "admin/orders";
    }
}
