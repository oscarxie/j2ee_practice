package com.mentor.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mentor.bean.UserInfo;



public class UserInfoDao extends HibernateDaoSupport {

    private SessionFactory sessionFacotry;  
    //注入一个bean, 默认(name = "sessionFactory"), 因此只写@Resource  
    @Resource       
    public void setSessionFacotry(SessionFactory sessionFacotry) {     
                super.setSessionFactory(sessionFacotry);     
    } 
	
	public UserInfo getUserInfoByLoginName(final String loginName) {
		List<UserInfo> list = (List<UserInfo>) this.getHibernateTemplate()
				.findByCriteria(
						DetachedCriteria.forClass(UserInfo.class).add(
								Restrictions.eq("username", loginName)));
		if (null == list || list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	public UserInfo getUserInfoById(final Long id) {
		System.out.println("getUserInfoById");
		return this.getHibernateTemplate().get(UserInfo.class, id);
	}

	public List<UserInfo> getUserInfoList() {
		return this.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(UserInfo.class));
	}

	public void update(final UserInfo userInfo) {
		this.getHibernateTemplate().update(userInfo);
	}

	public void add(final UserInfo userInfo) {
		this.getHibernateTemplate().save(userInfo);
	}

	public void delete(final Long id) {
		this.getHibernateTemplate().delete(this.getUserInfoById(id));
	}
}
