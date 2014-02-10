package com.asm.hibernate.test;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;

import com.asm.hibernate.domain.People;
import com.asm.hibernate.domain.User;
import com.asm.hibernate.utils.HibernateUtil;

public class HibernateCacheTest {
	public static void main(String[] args) {
		addUser();
		getUser(1);
		
		Statistics st = HibernateUtil.getSessionFactory().getStatistics();
		System.out.println(st);
		System.out.println("put:" + st.getSecondLevelCachePutCount());
		System.out.println("hit:" + st.getSecondLevelCacheHitCount());
		System.out.println("miss:" + st.getSecondLevelCacheMissCount());
	}

	static User getUser(int id) {
		Session s = null;
		User user = null;
		try {
			s = HibernateUtil.getSession();
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());

			// session缓存，当session未关闭时，再查询直接从缓存中获得数据。
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());
			
			
			// 如果我们清掉缓存，再查询时将会重新连库。
			s.evict(user);// 清掉指定的数据
			// s.clear();//清掉当前session缓存中的所有内容
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());
		} finally {
			if (s != null)
				s.close();
		}

		// 当上面的session关闭后，如果想再获取前面查询的数据，必须重新查库。
		try {
			s = HibernateUtil.getSession();
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());
		} finally {
			if (s != null)
				s.close();
		}
		return user;
	}

	static User deleteUser(int id) {
		Session s = null;
		User user = null;
		try {
			s = HibernateUtil.getSession();
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());

			// session缓存，当session未关闭时，再查询直接从缓存中获得数据。
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());

			s.delete(user);
		} finally {
			if (s != null)
				s.close();
		}
		return user;
	}
	static void addUser() {
		User user = new User();
		user.setName("genName");
		HibernateUtil.save(user);
	}
}
