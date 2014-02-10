package com.asm.hibernate.test;   
  
import java.util.Date;   
import org.hibernate.Session;   
import org.hibernate.SessionFactory;   
import org.hibernate.Transaction;   
import org.hibernate.cfg.Configuration;   
import com.asm.hibernate.domain.User;   
  
public class UserTest {   
    public static void main(String []args){   
        Configuration cf=new Configuration();   
        cf.configure();        
        SessionFactory sf=cf.buildSessionFactory();   
           
        Session s=sf.openSession();   
        Transaction ts=s.beginTransaction(); //事务   
           
        User user=new User();   
        user.setName("jack");   
        user.setDate(new Date());   
        s.save(user);   
        ts.commit(); //提交事务   
        s.close();   
        System.out.println("done");   
    }   
}  
