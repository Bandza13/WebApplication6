package model;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    public List<Product> findByType(int id){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> result = session.getNamedQuery("Product.findByType").setInteger("type", id).list();
        session.getTransaction().commit();
        return result;
    }
    
    public List<Product> find(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> result = session.createCriteria(Product.class).list();
        session.getTransaction().commit();
        return result;
    }
    
    public Product getById(int id){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = (Product)session.get(Product.class,id);
        session.getTransaction().commit();
        return product;
    }
    
    public List<Product> findByPage(int page){
        int perpage = 9;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> result = session.createQuery("from Product").setFirstResult(page*perpage).setMaxResults(perpage).list();
        session.getTransaction().commit();
        return result;
    }
    
    public Long pages(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Long result = ((Double)Math.ceil((Long)session.createQuery("select count(id) from Product").uniqueResult()/6)).longValue();
        session.getTransaction().commit();
        return result;
    }
    
    public void update(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
    }
    
    public void addProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }
    
    public void deleteProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
    }
}
