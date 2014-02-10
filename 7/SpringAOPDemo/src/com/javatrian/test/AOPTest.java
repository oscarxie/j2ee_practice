package com.javatrian.test;

import com.javatrian.PersonService;
import com.javatrian.imp.PersonServiceBean;

public class AOPTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AOPTest aopTest = new AOPTest();
		aopTest.jdkProxyTest();
		aopTest.cglibProxyTest();
	}

	public void jdkProxyTest() {
		JDKProxyFactory factory = new JDKProxyFactory();
		PersonService service = (PersonService) factory
				.createProxyIntance(new PersonServiceBean("xxx"));
		service.save("jdkProxyTest");
	}

	public void cglibProxyTest() {
		CGlibProxyFactory factory = new CGlibProxyFactory();
		PersonServiceBean service = (PersonServiceBean) factory
				.createProxyIntance(new PersonServiceBean("xxx"));
		service.save("cglibProxyTest");
	}

}
