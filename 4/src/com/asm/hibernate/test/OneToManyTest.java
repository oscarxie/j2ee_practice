package com.asm.hibernate.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asm.hibernate.domain.Department;
import com.asm.hibernate.domain.Employee;
import com.asm.hibernate.domain.User;
import com.asm.hibernate.utils.HibernateUtil;

public class OneToManyTest {
	public static void main(String[] args) {
	add();
//		query(1);
	//	nplusDept();
	}

	static Department query(int departId) {
		Session s = null;
		Department depart=null;
		try {
			s = HibernateUtil.getSession();
			 depart = (Department) s.get(Department.class, departId);
			 System.out.println("employee size:" + depart.getEmps().size());
			return depart;
		} finally {
			if (s != null)
				s.close();
			System.out.println("employee size:" + depart.getEmps().size());
		}
	}

	static void add() {
		Session s = null;
		Transaction tx = null;
		try {
			Department depart = new Department();
			depart.setName("departName");

			Employee emp1 = new Employee();
			emp1.setName("empName1");
			
			Employee emp2 = new Employee();
			emp2.setName("empName2");
			
			emp1.setDepart(depart);
			emp2.setDepart(depart);

			 Set<Employee> emps = new HashSet<Employee>();
			 emps.add(emp1);
			 emps.add(emp2);
			 depart.setEmps(emps);

			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			
		
			s.save(emp1);
			s.save(emp2);
			s.save(depart);
			
			tx.commit();
		} finally {
			if (s != null)
				s.close();
		}
	}
	
	static void nplusDept() {
		add();
		add();
		Session s = null;
		Department depart=null;
		try {
			s = HibernateUtil.getSession();
 	//	Department dep =(Department) s.get(Department.class, 1);
			
			Query q = s.getNamedQuery("selectDept");
			List<Department> lst =q.list();
			for (Department u:lst){
				System.out.println(u.getEmps());
				
			}
		} finally {
			if (s != null)
				s.close();
	
		}	
	}
}
