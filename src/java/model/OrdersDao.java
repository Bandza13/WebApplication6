package model;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class OrdersDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    public void save(Orders orders){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(orders);
        session.getTransaction().commit();
    }
    
    public List<Orders> find(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Orders> result = session.createCriteria(Orders.class).list();
        session.getTransaction().commit();
        return result;
    }
    
    public Orders getById(int id){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Orders result = (Orders)session.get(Orders.class,id);
        session.getTransaction().commit();
        return result;
    }
    
    public void delete(Orders orders){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(orders);
        session.getTransaction().commit();
    }
}
