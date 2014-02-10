package com.mentor;


import org.springframework.beans.factory.annotation.Autowired;

import com.mentor.service.HelloWorldService;

public class HelloWorldAction {
	private String message;
	private HelloWorldService hws;

	private String userName;
	private String userPwd;
	
	
	public String login() {
		//this.message = hws.getUserInfoById(1L).getUsername();
		try{
		this.message = hws.getUserInfoByLoginName(userName).getUsername();
		System.out.println("pwd is:" + hws.getUserInfoByLoginName(userName).getPassword());
		return "success";
		}catch (NullPointerException e){
			//e.printStackTrace();
			this.message="用户名不存在";
			return "success";
		}
	}
	//*******************************************************88888
	
	

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

	public String getMessage() {
		return message;
	}

	public HelloWorldService getHws() {
		return hws;
	}

	public void setHws(HelloWorldService hws) {
		this.hws = hws;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
