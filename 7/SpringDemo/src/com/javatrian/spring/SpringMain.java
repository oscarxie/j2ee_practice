package com.javatrian.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;


public class SpringMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/applicationContext-*.xml");

		DIShow dIShow = (DIShow) context.getBean("DIShow");
		dIShow.sayHello();

		HelloWorldSpring hs = (HelloWorldSpring) context
				.getBean("HelloWorldSpring");
		hs.sayHello();

		BeanFactory factory = new XmlBeanFactory(
				new FileSystemResource(
						"I:/Documents/Java/7/code/SpringDemo/src/conf/applicationContext-service-api.xml"));
		DIShow ds = (DIShow) factory.getBean("DIShow");
		ds.sayHello();

	}

}
