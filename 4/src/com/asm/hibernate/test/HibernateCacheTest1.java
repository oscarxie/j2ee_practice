package com.asm.hibernate.test;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;

import com.asm.hibernate.domain.Name;
import com.asm.hibernate.domain.People;
import com.asm.hibernate.utils.HibernateUtil;

public class HibernateCacheTest1 {
	public static void main(String[] args) {
		addUser();
		getUser(1);
		Statistics st = HibernateUtil.getSessionFactory().getStatistics();
		System.out.println(st);
		System.out.println("put:" + st.getSecondLevelCachePutCount());
		System.out.println("hit:" + st.getSecondLevelCacheHitCount());
		System.out.println("miss:" + st.getSecondLevelCacheMissCount());

	}

	
	static People getUser(int id) {
		Session s = null;
		People user = null;
		try {
			s = HibernateUtil.getSession();
			user = (People) s.get(People.class, id);
			System.out.println("userName:" + user.getName());

			// session缓存，当session未关闭时，再查询直接从缓存中获得数据。
			user = (People) s.get(People.class, id);
			System.out.println("userName:" + user.getName());

			// 如果我们清掉缓存，再查询时将会重新连库。
			s.evict(user);// 清掉指定的数据
			// s.clear();//清掉当前session缓存中的所有内容
			user = (People) s.get(People.class, id);
			System.out.println("userName:" + user.getName());
			
		} finally {
			if (s != null)
				s.close();
		}

		// 当上面的session关闭后，如果想再获取前面查询的数据，必须重新查库。
		try {
			s = HibernateUtil.getSession();
			user = (People) s.get(People.class, id);
			System.out.println("userName:" + user.getName());
		} finally {
			if (s != null)
				s.close();
		}
		return user;
	}

	
	
	static void addUser() {
		People user = new People();
		Name name= new Name();
		name.setFirstName("ryan");
		name.setSecondName("Zhang");
		user.setName(name);
		HibernateUtil.save(user);
	}
}
