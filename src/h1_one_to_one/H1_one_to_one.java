/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author arjun
 */
public class H1_one_to_one {
    
private static SessionFactory factory;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            factory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            
        }catch(Throwable ex){
            System.err.println("failed"+ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session=factory.openSession();
        Transaction transaction=null;
        try{
            transaction =session.beginTransaction();
Address address=new Address();
address.setAddressStreet("rajagiri");
address.setAddressCity("Cochin");
address.setAddressState("kerala");
address.setAddressZipcode("682313");

Student student =new Student ();
student.setStudentName("shiju");
student.setStudentEmail("one@gmail.com");
student.setAddress(address);
address.setStudent(student);

session.save(student);
session.save(address);
transaction.commit();
        }catch(Exception e){
            
        }finally{
            session.close();
        }
        System.exit(0);
    }
    
}
