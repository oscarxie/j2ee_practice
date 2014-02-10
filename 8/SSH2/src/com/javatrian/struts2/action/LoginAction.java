package com.javatrian.struts2.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.javatrian.struts2.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	public final static String LOGIN_SESSION_KEY = "LOGIN_KEY";
	private String message ;
	private UserInfoService userInfoService;
	private String userName;
	private String userPwd;
	
	public String login() throws Exception {
		ApplicationContext ctx = WebApplicationContextUtils
		.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		System.out.println("username is:" + userName);		
		int result = userInfoService.login(userName, userPwd);
		switch (result) {
		case 1:
			message = "user does not exist";
			return "Error";
		case 3:
			message = "password error";
			return "Error";
		}

		ServletActionContext.getRequest().getSession().setAttribute(LOGIN_SESSION_KEY, userName);
		return "userList";
	}

	public String logout()
			throws Exception {
		ServletActionContext.getRequest().getSession().invalidate();

		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
