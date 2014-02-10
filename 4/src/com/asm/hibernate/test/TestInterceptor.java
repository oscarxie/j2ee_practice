package com.asm.hibernate.test;

import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.asm.hibernate.domain.User;
import com.asm.hibernate.intercept.AutoUpdateTimeInterceptor;
import com.asm.hibernate.utils.HibernateUtil;

public class TestInterceptor
{
    public static void main(String[] args)
    {
        /*ÎªSessionÌí¼ÓÀ¹½ØÆ÷*/
    	Interceptor interceptor = new AutoUpdateTimeInterceptor();
    	Configuration cf=	new Configuration();
    	cf.setInterceptor(interceptor);
		cf.configure();
        Session session = cf.buildSessionFactory().openSession();
      //  Session session = cf.buildSessionFactory().openSession(interceptor);
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            
            User people = new User();
           
            people.setName("tom");
            
            session.save(people);
            
            tx.commit();
        }
        catch (Exception e)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
            
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
}
