package util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import domain.HibernateUtil;
import domain.User;

public class UserExist {
	// 判断用户是否存在
	// public static boolean isExist(String username, String password) {
	// String name = username.trim();
	// String word = password.trim();
	//
	// if (name.equals("yuan") && word.equals("123"))
	// return true;
	// return false;
	// }
	//
	
	public static boolean isExist(String username, String password) {
		String name = username.trim();
		String word = password.trim();
			
		System.out.println("-------AAA--------");
		
		User user = getUser(name);
		if (name.equals(user.getUsername()) && word.equals(user.getPassword())){
			return true;
		}else{
		return false;
		}
		
	}
	
	
	public static User getUser(String username) {
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			//User user = (User) s.load(User.class, username);
			
			Query q = s.getNamedQuery("selectUserbyName");
			q.setString("username", username);
			List lst = q.list();
			User user = (User)(lst.get(0));
			//Hibernate.initialize(user);
			 System.out.println(user.getUsername());
		     System.out.println(user.getId());

			System.out.println("load--User:" + user.getClass());

			return user;
		} finally {
			if (s != null)
				s.close();
		}
	}
}