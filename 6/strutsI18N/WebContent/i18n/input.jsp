<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>register</title>
	<meta http-equiv="pragma" content="no-cache">
  </head>
  
  <body>
  	<s:actionerror/>
  	
  	<s:text name="wintys.i18n.title" />
  	
    <s:form action="i18n" >
    	<!--s:textfield name="name" label="姓名"/ -->
    	<!-- s:textfield name="age" label="年龄" / -->
    	<!-- s:submit name="submit" value=" 提交  " / -->
    	<s:textfield name="name" key="wintys.i18n.name"></s:textfield><br/>
    	<s:textfield name="age" key="wintys.i18n.age"></s:textfield><br/>
    	<s:submit name="submit" key="wintys.i18n.submit"></s:submit>
    </s:form>
    
    <s:i18n name="messagefile">
    	<s:text  name="wintys.i18n.desc"/><br/>
    	<s:text name="wintys.i18n.addition">
    		<s:param>Hello</s:param>
    	</s:text>
    </s:i18n>
  </body>
</html>
