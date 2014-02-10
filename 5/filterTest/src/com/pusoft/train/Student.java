package com.pusoft.train;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Student implements HttpSessionBindingListener {
	private int age = 30;

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		age += 10;

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		age -= 5;

	}

	public int getAge() {
		return age;
	}
}
