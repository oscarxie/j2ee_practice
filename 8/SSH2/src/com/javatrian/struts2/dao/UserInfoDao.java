package com.javatrian.struts2.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.javatrian.struts2.model.UserInfo;

public class UserInfoDao extends HibernateDaoSupport {

	public UserInfo getUserInfoByLoginName(final String loginName) {
		System.out.println("loginName is:" + loginName);
		List<UserInfo> list = (List<UserInfo>) this.getHibernateTemplate()
				.findByCriteria(
						DetachedCriteria.forClass(UserInfo.class).add(
								Restrictions.eq("loginName", loginName)));
		if (null == list || list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	public UserInfo getUserInfoById(final Long id) {
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
