package com.example.HiberManytoOne;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Entity.Address;
import com.example.Entity.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        try 
        {
       	Address a1=new Address();
       	a1.setStreet("Hyd");
       	
        	Customer c1=new Customer();
        	c1.setName("Rajashekar");
        	c1.setAddress(a1);
        	
        	Customer c2=new Customer();
        	c2.setName("Shekar");
        	c2.setAddress(a1);
        	
        	session.beginTransaction();
        	session.save(a1);
        	session.save(c1);
        	session.save(c2);
        	session.getTransaction().commit();
        	
        	
        	
   
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally 
        {
        	session.close();
        	factory.close();
        }

    }
}
