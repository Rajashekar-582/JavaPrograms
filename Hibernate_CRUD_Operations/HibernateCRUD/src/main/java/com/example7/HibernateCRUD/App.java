package com.example7.HibernateCRUD;

import java.sql.SQLException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example7.model.Employee;

public class App 
{
	static Scanner sc=new Scanner(System.in);
	
	void insertData() throws SQLException
	{
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        
		System.out.println("Enter no of records");
		 int n=sc.nextInt();
		 for(int i=0;i<n;i++)
		 {
			 Employee e1=new Employee();
			 System.out.println("Enter Employee name:");
			 e1.setEmp_Name(sc.next());
			 System.out.println("Enter Salary");
			 e1.setSalary(sc.nextFloat());
			 
			 
			session.save(e1);
			System.out.println("One record inserted successfully");
		 }
		
		
	}
	void selectData() throws SQLException
	{
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        
        System.out.println("Enter Employee number:");
        Employee e1=session.get(Employee.class,sc.nextInt() );
        System.out.println("Employee_id:"+e1.getId());
        System.out.println("Employee_name:"+e1.getEmp_Name());
        System.out.println("Salary:"+e1.getSalary());
        
        session.save(e1);
        
		
	}
	void updateData() throws SQLException
	{
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        
        System.out.println("Enter Employee number to update:");
        Employee e1=session.get(Employee.class, sc.nextInt());
        
        if(e1 != null)
        {
        	System.out.println("Enter new Salary to update:");
        	e1.setSalary(sc.nextFloat());
        	session.update(e1);
        	System.out.println("One record is updated");
        	
        }
        else 
        {
        	System.out.println("Record is not updated");
        }
        
		
	}
	void deleteData() throws SQLException
	{
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        
        System.out.println("Enter Employee number to delete:");
        Employee e1=session.get(Employee.class, sc.nextInt());
        
        if(e1 != null)
        {
        	session.delete(e1);
        	System.out.println("one record is successfully deleted");
        }
        else
        {
        	System.out.println("Record not found on the employee number");
        }
        
		
	}
    public static void main( String[] args )
    {
    	
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        
        
        App crud=new App();
        try{
        	session.beginTransaction();
        int choice;
		 do{
			 System.out.println("Enter your choice");
			 System.out.println("1.Insert");
			 System.out.println("2.select");
			 System.out.println("3.Update");
			 System.out.println("4.Delete");
			 choice=sc.nextInt();
			 switch(choice)
			 {
			 case 1:
				 crud.insertData();
				 break;
			 case 2:
				 crud.selectData();
				 break;
			 case 3:
				 crud.updateData();
				 break;
			 case 4:
				 crud.deleteData();
				 break;
			 case 5:
				 break;
			 }
			 
			 
		 }while(choice!=5);
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
