package com.javatrian.imp;

import com.javatrian.PersonService;

public class PersonServiceBean implements PersonService {
	private String user = null;

	public String getUser() {
		return user;
	}

	public PersonServiceBean() {
	}

	public PersonServiceBean(String user) {
		this.user = user;
	}

	public String getPersonName(Integer personid) {
		System.out.println("call getPersonName()");
		return "xxx";
	}

	public void save(String name) {
		System.out.println("call save()");
	}

	public void update(String name, Integer personid) {
		System.out.println("call update()");
	}
}
