<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>

<head>

<title>请输入您的注册信息</title>
<s:head theme="ajax"/>

</head>


<body>
<H1>请输入您的注册信息</H1>
<s:form action="regist" theme="ajax" validate="true">
	<s:textfield name="name" label="作者名"/><br>
	<s:textfield name="pass" label="密码"/>
	<s:textfield name="age" label="年龄"/>
	<s:textfield name="birth" label="生日"/>
	<s:submit value="注册"/>
</s:form>

</body>

</html>