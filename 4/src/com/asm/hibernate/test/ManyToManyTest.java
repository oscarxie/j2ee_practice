package com.asm.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asm.hibernate.domain.Student;
import com.asm.hibernate.domain.Teacher;
import com.asm.hibernate.utils.HibernateUtil;

public class ManyToManyTest {
	public static void main(String[] args) {
		add();
	}

	static void add() {
		Session s = null;
		Transaction tr = null;
		try {
			s = HibernateUtil.getSession();
			tr = s.beginTransaction();

			Teacher t1 = new Teacher();
			t1.setName("t1Name");

			Teacher t2 = new Teacher();
			t2.setName("t2Name");

			Student s1 = new Student();
			s1.setName("s1Name");

			Student s2 = new Student();
			s2.setName("s2Name");

			// 再增加如下内容进行测试：
			Set<Teacher> ts = new HashSet<Teacher>();
			ts.add(t1);
			ts.add(t2);
			Set<Student> ss = new HashSet<Student>();
			ss.add(s1);
			ss.add(s2);

			t1.setStudents(ss);
			t2.setStudents(ss);

//			 s1.setTeachers(ts);
//			 s2.setTeachers(ts);
			// 增加内容完
			s.save(s1);
			s.save(s2);
			s.save(t1);
			s.save(t2);
			tr.commit();

		} finally {
			if (s != null)
				s.close();
		}
	}
}
