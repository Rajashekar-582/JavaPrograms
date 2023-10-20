package com.example.Connection1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Entity.Passport;
import com.example.Entity.Person;
//import com.example.Model.Student;

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
        Session s=factory.openSession();
        
        try
        {
        	/*Student s1=new Student();
        	s1.setName("Rajashekar");
        	s1.setMarks(98);
        	s.beginTransaction();
        	s.save(s1);
        	s.getTransaction().commit();
        	
        	Student s2=s.get(Student.class,s1.getId());
        	
        	System.out.println("Student ID:"+s1.getId());
        	System.out.println("Student Name:"+s1.getName());
        	System.out.println("Student Marks:"+s1.getMarks());*/
        	
        	Person p1=new Person();
        	p1.setName("Shekar");
        	
        	Passport p2=new Passport();
        	p2.setPassport_no("AF0332197");
        	
        	p1.setPassport(p2);
        	p2.setPerson(p1);
        	
        	s.beginTransaction();
        	s.save(p1);
        	s.getTransaction().commit();
        	
        	
        	Person r1=s.get(Person.class, p1.getId());
        	Passport r2=r1.getPassport();
        	
        	System.out.println("Person ID:"+r1.getId());
        	System.out.println("Person Name:"+r1.getName());
        	System.out.println("Passport No:"+r2.getPassport_no());
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally{
        	s.close();
        	factory.close();
        }
        
    }
}
