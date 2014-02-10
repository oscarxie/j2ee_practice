<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>login</title>
		<SCRIPT LANGUAGE="JavaScript">
<c:if test="${null!=message}"> 
  alert('<c:out value="${message}"/>');
</c:if>
</SCRIPT>
	</head>
	<body>
		<form method="post" action="login!login.do" name="userInfo"
			id="userInfo">
			<fmt:message key="userName" />
			<input name="userName" id="userName" type="text"">
			<br>
			<fmt:message key="userPwd" />
			<input name="userPwd" id="userPwd" type="password"">
			<br>
			<input type="submit" value='<fmt:message key="submit"/>' />
		</form>
	</body>
</html>