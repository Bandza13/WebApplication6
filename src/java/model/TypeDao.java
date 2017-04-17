package model;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypeDao {
    
    @Autowired
    SessionFactory sessionFactory;        
    
    public List<Type> find(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Type> result = session.createCriteria(Type.class).list();
        session.getTransaction().commit();
        return result;
    }
    
    public Type getById(int id){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Type type = (Type)sessionFactory.getCurrentSession().get(Type.class, id);
        session.getTransaction().commit();
        return type;
    }
    
    public void update(Type type){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(type);
        session.getTransaction().commit();
    }
    
    public void deleteType(Type type){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(type);
        session.getTransaction().commit();
    }
    
    public void addType(Type type){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(type);
        session.getTransaction().commit();
    }
}
