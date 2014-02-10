package com.asm.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilSelf {
	private static SessionFactory sf;

	private HibernateUtilSelf() {
	}

	public static Session getThreadLocalSession() {
		Session s = sf.getCurrentSession();
		if (s == null) {
			s = getSession();
		}
		return s;
	}

	static {
		Configuration cf = new Configuration();
		cf.configure();
		sf = cf.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

	public static Session getSession() {
		return sf.openSession();
	}
}
