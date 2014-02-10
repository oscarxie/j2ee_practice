<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> pageEncoding="UTF-8"-->
		<title>login</title>
		<SCRIPT LANGUAGE="JavaScript">
			<c:if test="${null!=resMessage}"> 
			  alert('<c:out value="${resMessage}"/>');
			</c:if>
		</SCRIPT>
	</head>
	<body>
		login
		<s:form method="post" action="test/login.do" id="userInfo">
			<s:text name="userName" /><!-- 使用了国际化 -->
			<s:textfield name="userName" id="userName" type="text"/>
			<br>
			<s:text name="userPwd" />
			<s:textfield name="userPwd" id="userPwd" type="password"/>
			<br>
			<input type="submit" value='<s:text name="submit"/>' />
		</s:form>
		
	</body>
</html>