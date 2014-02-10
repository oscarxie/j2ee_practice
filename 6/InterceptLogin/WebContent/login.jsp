<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
     String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
 %>

  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <html>
    <head>
         <base href="<%=basePath%>">
         <title>登录界面</title>
         <meta http-equiv="pragma" content="no-cache">
         <meta http-equiv="cache-control" content="no-cache">
         <meta http-equiv="expires" content="0">
         <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
         <meta http-equiv="description" content="This is my page">
   </head>
   <body>
         <center>
             <font color="bule" size="20">用户登录</font>
             <br>
             <s:form action="test/logintest">
                 <s:textfield name="username" label="用户名:" size="20"></s:textfield>
                 <s:textfield name="password" label="密码:" size="20"></s:textfield>
                 <s:submit value="提交"></s:submit>
             </s:form>

         </center>
     </body>
 </html>