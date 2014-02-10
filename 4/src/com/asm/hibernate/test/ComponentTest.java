package com.asm.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asm.hibernate.domain.Name;
import com.asm.hibernate.domain.People;
import com.asm.hibernate.utils.HibernateUtil;

public class ComponentTest {

	public static void main(String[] args) {
		Name n = new Name();
		n.setFirstName("zhang");
		n.setSecondName("san");
		People p = new People();
		p.setName(n);
		add(p);
	}

	static void add(People p) {
		Session s = null;
		Transaction ts = null;
		try {
			s = HibernateUtil.getSession();
			ts = s.beginTransaction();
			s.save(p);
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
