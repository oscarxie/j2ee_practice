<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.javatrian.spring.HelloWorldSpring"%>
<%
	ApplicationContext ctx = WebApplicationContextUtils
			.getRequiredWebApplicationContext(this.getServletConfig()
					.getServletContext());
	HelloWorldSpring hello = (HelloWorldSpring) ctx
			.getBean("HelloWorldSpring");
	out.println(hello.sayHello());
%>