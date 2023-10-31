package com.example3.HibManytoMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example3.model.Cart;
import com.example3.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        */
    	
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();

        try 
        {
        session.beginTransaction();
        Cart c1=new Cart();
        c1.setPrice(200);
        
        Cart c2=new Cart();
        c2.setPrice(300);
        
        Product p1=new Product();
        p1.setName("wheet");
        
        Product p2=new Product();
        p2.setName("bread");
        
       c1.getProducts().add(p1);
       c1.getProducts().add(p2);
       c2.getProducts().add(p1);
       c2.getProducts().add(p2);
       
        
        session.save(c1);
        session.save(c2);
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();
        }
        finally 
        {
        	session.close();
        	factory.close();
        }    
    }
}
