package com.javatrian.struts2.action;

import java.util.List;

import com.javatrian.struts2.model.UserInfo;
import com.javatrian.struts2.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport {
	private UserInfoService userInfoService;
	private List userList;
	private UserInfo userInfo;
	public String list() throws Exception {
		userList = userInfoService.list();

		return "list";
	}

	public String save() throws Exception {
		if (null == userInfo || null == userInfo.getId()
				|| 0 == userInfo.getId())
			userInfoService.add(userInfo);
		else
			userInfoService.update(userInfo);

		return "userList";
	}

	public String delete() throws Exception {
		userInfoService.delete(userInfo.getId());
		return "userList";
	}

	public String update() throws Exception {
		if (null == userInfo || null == userInfo.getId()||0 == userInfo.getId())
			return "userList";
		else {
			userInfo = userInfoService.getUserInfoById(userInfo.getId());
			
			return "update";
		}
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
