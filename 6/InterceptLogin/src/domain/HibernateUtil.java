package domain;

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

}
