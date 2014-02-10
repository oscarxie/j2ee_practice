package mypack;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class BusinessService{
  public static SessionFactory sessionFactory;
  static{
     try{
      // Create a configuration based on the properties file we've put
       Configuration config = new Configuration();
      //load hibernate.cfg.xml
       config.configure();
      // Get the session factory we can use for persistence
      sessionFactory = config.buildSessionFactory();
    }catch(RuntimeException e){e.printStackTrace();throw e;}
  }

  public void findAllCustomers(){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();

      System.out.println("findAllCustomers():executing session.createQuery().list()");
      List customerLists=session.createQuery("from Customer as c").list();

      System.out.println("findAllCustomers():executing customerLists.iterator()");
      Iterator customerIterator=customerLists.iterator();

      System.out.println("findAllCustomers():iterating customer1");
      Customer customer1=(Customer)customerIterator.next();

      System.out.println("findAllCustomers():iterating customer2");
      Customer customer2=(Customer)customerIterator.next();

      System.out.println("findAllCustomers():iterating customer3");
      Customer customer3=(Customer)customerIterator.next();

      System.out.println("findAllCustomers():iterating customer4");
      Customer customer4=(Customer)customerIterator.next();

      System.out.println("findAllCustomers():executing customer1.getOrders().iterator()");
      Iterator orderIterator1=customer1.getOrders().iterator();

      System.out.println("findAllCustomers():executing customer2.getOrders().iterator()");
      Iterator orderIterator2=customer2.getOrders().iterator();

      System.out.println("findAllCustomers():executing customer3.getOrders().iterator()");
      Iterator orderIterator3=customer3.getOrders().iterator();

      System.out.println("findAllCustomers():executing customer4.getOrders().iterator()");
      Iterator orderIterator4=customer4.getOrders().iterator();

      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
         tx.rollback();
      }
      throw e;
    } finally {
       session.close();
    }
  }

  public void loadCustomer(){

    Session session = sessionFactory.openSession();
    Transaction tx = null;
    Customer customer=null;
    try {
      tx = session.beginTransaction();
      
      System.out.println("loadCustomer():executing session.load()");
      customer=(Customer)session.load(Customer.class,new Long(1));
      
      System.out.println("loadCustomer():executing customer.getName()");
      customer.getName();
 
      System.out.println("loadCustomer():executing customer.getOrders().iterator()");
      Iterator orderIterator=customer.getOrders().iterator();

    
      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    } finally {
      session.close();
    }
  }

  public void getCustomer(){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      System.out.println("getCustomer():executing session.get()");
      Customer customer=(Customer)session.get(Customer.class,new Long(1));
      
      System.out.println("getCustomer():executing customer.getName()");
      customer.getName();
      
      System.out.println("getCustomer():executing customer.getOrders().iterator()");
      Iterator orderIterator=customer.getOrders().iterator();

      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    } finally {
      session.close();
    }
  }

  public void getOrder(){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      System.out.println("getOrder():executing session.get()");
      Order order=(Order)session.get(Order.class,new Long(1));
      
      System.out.println("getOrder():executing order.getOrderNumber()");
      order.getOrderNumber();
      
      System.out.println("getOrder():executing order.getCustomer()");
      Customer customer=order.getCustomer();

      System.out.println("getOrder():executing customer.getName()");
      customer.getName();

      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    } finally {
      session.close();
    }
  }

  public void loadOrder(){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      System.out.println("loadOrder():executing session.load()");
      Order order=(Order)session.load(Order.class,new Long(1));
      
      System.out.println("loadOrder():executing order.getOrderNumber()");
      order.getOrderNumber();
      
      System.out.println("loadOrder():executing order.getCustomer()");
      Customer customer=order.getCustomer();

      System.out.println("loadOrder():executing customer.getName()");
      customer.getName();

      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    } finally {
      session.close();
    }
  }

  public void findAllOrders(){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();

      System.out.println("findAllOrders():executing session.createQuery().list()");
      List orderLists=session.createQuery("from Order as c ").list();

      System.out.println("findAllOrders():executing orderLists.iterator()");
      Iterator orderIterator=orderLists.iterator();

      System.out.println("findAllOrders():iterating order1");
      Order order1=(Order)orderIterator.next();

      System.out.println("findAllOrders():iterating order2");
      Order order2=(Order)orderIterator.next();

      System.out.println("findAllOrders():iterating order3");
      Order order3=(Order)orderIterator.next();

      System.out.println("findAllOrders():iterating order4");
      Order order4=(Order)orderIterator.next();

      System.out.println("findAllOrders():iterating order5");
      Order order5=(Order)orderIterator.next();
      
      System.out.println("findAllOrders():iterating order6");
      Order order6=(Order)orderIterator.next();

      System.out.println("findAllOrders():executing order1.getCustomer()");
      Customer customer1=order1.getCustomer();

      System.out.println("findAllOrders():executing customer1.getName()");
      if(customer1!=null) customer1.getName();

      System.out.println("findAllOrders():executing order2.getCustomer()");
      Customer customer2=order2.getCustomer();

      System.out.println("findAllOrders():executing customer2.getName()");
      if(customer2!=null)customer2.getName();

      System.out.println("findAllOrders():executing order3.getCustomer()");
      Customer customer3=order3.getCustomer();

      System.out.println("findAllOrders():executing customer3.getName()");
      if(customer3!=null)customer3.getName();

      System.out.println("findAllOrders():executing order4.getCustomer()");
      Customer customer4=order4.getCustomer();

      System.out.println("findAllOrders():executing customer4.getName()");
      if(customer4!=null)customer4.getName();

      System.out.println("findAllOrders():executing order5.getCustomer()");
      Customer customer5=order5.getCustomer();

      System.out.println("findAllOrders():executing customer5.getName()");
      if(customer5!=null)customer5.getName();

      System.out.println("findAllOrders():executing order6.getCustomer()");
      Customer customer6=order6.getCustomer();

      System.out.println("findAllOrders():executing customer6.getName()");
      if(customer6!=null)customer6.getName();

      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    } finally {
      session.close();
    }
  }

  public void findCustomerLeftJoinOrder(){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      System.out.println("findCustomerLeftJoinOrder():executing session.createQuery().list()");
      List customerLists=session
       .createQuery("from Customer as c left join fetch c.orders where c.id=1")
       .list();
      
      System.out.println("findCustomerLeftJoinOrder():executing customerLists.iterator()");
      Iterator customerIterator=customerLists.iterator();
      
      System.out.println("findCustomerLeftJoinOrder():iterating customer");
      Customer customer=(Customer)customerIterator.next();

      System.out.println("findCustomerLeftJoinOrder():executing customer.getOrders().iterator()");
      Iterator orderIterator=customer.getOrders().iterator();

      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    } finally {
      session.close();
    }
  }

    public void test(){
      loadCustomer();
      getCustomer();
      findAllCustomers();
      
      loadOrder();
      getOrder();
      findAllOrders();
      findCustomerLeftJoinOrder();
  }

  public static void main(String args[]) throws Exception {
    new BusinessService().test();
    sessionFactory.close();
  }
}







/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<精通Hibernate：Java对象持久化技术详解>>  *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
