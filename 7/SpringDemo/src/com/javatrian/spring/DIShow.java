package com.javatrian.spring;

public class DIShow {
	private HelloWorldSpring helloWorldSpring;

	public HelloWorldSpring getHelloWorldSpring() {
		return helloWorldSpring;
	}

	public void setHelloWorldSpring(HelloWorldSpring helloWorldSpring) {
		this.helloWorldSpring = helloWorldSpring;
	}

	public void sayHello(){
		System.out.println("DIShow say:" + helloWorldSpring.sayHello());
	}
}
