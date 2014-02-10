package com.asm.hibernate.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asm.hibernate.domain.User;
import com.asm.hibernate.utils.HibernateUtil;
import com.asm.hibernate.utils.HibernateUtilSelf;

public class UserTest2 {
	public static void main(String[] args) {
		 addUser();

	//	addUser1();
		// User u = getUser(1);
		// System.out.println("return type:" + u + "\t name=" + u.getName());

	//	update(1);
		namedQuery(1);
		//nplusUser();
	}

	static User getUser(int id) {
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			User user = (User) s.get(User.class, id);
			//User user = (User) s.load(User.class, id);

			// 以下的两种方式都可以让懒加载去真正连接数据库。
			//Hibernate.initialize(user);
			 System.out.println(user.getName());
		//	System.out.println(user.getId());// 查询 id不能引起连接数据库

			System.out.println("load--User:" + user.getClass());

			return user;
		} finally {
			if (s != null)
				s.close();
		}
	}

	static void addUser() {
		Session s = null;
		Transaction ts = null;
		try {
			User user = new User();
			user.setName("jack");
			user.setDate(new Date());
			s = HibernateUtil.getSession();
			ts = s.beginTransaction();
			s.save(user);
			user.setName("jack_new");
		//	s.save(user);
			ts.commit();
		} catch (HibernateException e) {
			if (ts != null)
				ts.rollback();
			throw e;
		} finally {
			if (s != null)
				s.close();
		}
	}

	static void addUser1() {
		Session s = null;
		Transaction ts = null;
		try {
			s = HibernateUtilSelf.getThreadLocalSession();
			ts = s.beginTransaction();
			User user = new User();
			user.setName("jack");
			user.setDate(new Date());
			s.save(user);
			ts.commit();
		} catch (HibernateException e) {
			if (ts != null)
				ts.rollback();
			throw e;
		} finally {
			if (s != null)
			//	s.close(); //注意这里不能使用close,并注意下面的打印结果
				System.out.println("s=" + s);
		}
	}

	static void update(int id) {
		Session s1 = null;
		Session s2 = null;
		Transaction tx1 = null;
		Transaction tx2 = null;
		try {
			s1 = HibernateUtil.getSession();
			tx1 = s1.beginTransaction();
			User user1 = (User) s1.get(User.class, id);
			System.out.println(user1.getName());
			s2 = HibernateUtil.getSession();
			tx2 = s2.beginTransaction();
			User user2 = (User) s2.get(User.class, id);

			user1.setName("user1Name");
			user2.setName("user2Name");

			tx1.commit();
			tx2.commit();
		} catch (HibernateException e) {
			// if (tx1 != null)
			// tx1.rollback();
			// if (tx2 != null)
			// tx2.rollback();
			throw e;
		} finally {
			s1.close();
			s2.close();
		}
	}

	static List namedQuery(int id) {
		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("selectUserbyId");
		// Query q = s.getNamedQuery("selectUserSql");
		// Query
		// q=s.getNamedQuery("com.asm.hibernate.domain.User.selectUserbyIdTheSecond");
		q.setInteger("id", id);
		List<User> lst = q.list();
		for (User u : lst) {
			System.out.println(u.getName());
		}
		return lst;
	}

	static void nplusUser() {
		Session s = null;
		Transaction ts = null;
		try {
			s = HibernateUtil.getSession();
			ts = s.beginTransaction();

			for (int i = 0; i < 5; i++) {
				User user = new User();
				user.setName("jack" + i);
				user.setDate(new Date());
				s.save(user);

			}
			ts.commit();

		} catch (HibernateException e) {
			if (ts != null)
				ts.rollback();
			throw e;
		} finally {
			if (s != null)
				s.close();
		}
	}
}
