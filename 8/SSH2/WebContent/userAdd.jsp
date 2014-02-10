<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:form action="userInfo!save.do" method="post" id="userInfo" >
	<s:text name="loginName"/>
	<s:textfield name="userInfo.loginName" id="loginName" size="20" />
	<br>
	<fmt:message key="userName" />
	<s:textfield name="userInfo.userName" id="userName" size="20" />
	<br>
	<fmt:message key="userPwd" />
	<s:textfield name="userInfo.pwd" id="pwd" size="20" />
	<br>
	<input type="submit" value='<fmt:message key="submit"/>' />
</s:form>

