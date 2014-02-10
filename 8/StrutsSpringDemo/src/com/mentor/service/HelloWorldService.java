package com.mentor.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.mentor.bean.UserInfo;
import com.mentor.dao.UserInfoDao;



public class HelloWorldService {
	
	private UserInfoDao userInfoDao;
	public UserInfo getUserInfoById(final long id) {
		return userInfoDao.getUserInfoById(id);
	}
	
	
	public UserInfo getUserInfoByLoginName(final String loginName) {
		return userInfoDao.getUserInfoByLoginName(loginName);
	}
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
}
