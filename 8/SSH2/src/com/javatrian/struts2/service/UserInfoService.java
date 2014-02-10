package com.javatrian.struts2.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrian.struts2.dao.UserInfoDao;
import com.javatrian.struts2.model.UserInfo;

@Service(value = "userInfoService")
public class UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;

	public int login(final String loginName, final String pwd) {
		UserInfo userInfo = userInfoDao.getUserInfoByLoginName(loginName);
		if (null == userInfo)
			return 1;
		else if (pwd.equals(userInfo.getPwd()))
			return 2;
		else
			return 3;
	}

	public List<UserInfo> list() {
		return userInfoDao.getUserInfoList();
	}

	public UserInfo getUserInfoById(final long id) {
		return userInfoDao.getUserInfoById(id);
	}

	public void add(final UserInfo userInfo) {
		userInfoDao.add(userInfo);
	}

	public void delete(final long id) {
		userInfoDao.delete(id);
	}

	public void update(final UserInfo userInfo) {
		userInfoDao.update(userInfo);
	}
}
