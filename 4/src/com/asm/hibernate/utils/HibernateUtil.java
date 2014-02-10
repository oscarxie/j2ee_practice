package com.asm.hibernate.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	private static Configuration cf ;

	private HibernateUtil() {

	}

	static {
		 cf = new Configuration();
		 
		cf.configure();
		sf = cf.buildSessionFactory();
	}

	public static Configuration getCf() {
		return cf;
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

	public static Session getSession() {
		return sf.openSession();
	}

	// 统一的数据添加操作
	public static void save(Object obj) {
		Session s = null;
		Transaction ts = null;
		try {
			s = HibernateUtil.getSession();
			ts = s.beginTransaction();
			s.saveOrUpdate(obj);
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

	// 统一的删除操作
	public static void delete(Object obj) {
		Session s = null;
		Transaction ts = null;
		try {
			s = HibernateUtil.getSession();
			ts = s.beginTransaction();
			s.delete(obj);
			ts.commit();
		} finally {
			if (s != null)
				s.close();
		}
	}

	// 统一的更新操作
	public static void update(Object obj) {
		Session s = null;
		Transaction ts = null;
		try {
			s = HibernateUtil.getSession();
			ts = s.beginTransaction();
			s.update(obj);
			ts.commit();
		} finally {
			if (s != null)
				s.close();
		}
	}
}
