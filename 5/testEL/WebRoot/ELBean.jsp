<%@ page language="java" pageEncoding="UTF-8"%> 
<%@ page import="java.util.*,com.meixin.beans.*"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
  <head> 
    <title>My JSP 'elExample1.jsp' starting page</title> 
    <meta http-equiv="pragma" content="no-cache"> 
    <meta http-equiv="cache-control" content="no-cache"> 
    <meta http-equiv="expires" content="0"> 
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
    <meta http-equiv="description" content="This is my page"> 
    <!-- 
  <link rel="stylesheet" type="text/css" href="styles.css"> 
  --> 
  </head> 
  <body> 
  <!-- 使用User Bean，设置属性值username --> 
  <jsp:useBean id="user" class="com.meixin.beans.User"></jsp:useBean> 
  <jsp:setProperty name="user" property="userName" value="meixin"/> 
  <% 
    //建立Profile对象，设置邮件地址 
    Profile p = new Profile(); 
    p.setEmail("wnight88@sina.com"); 
     
    //将不同的电话存入Map中，并设置在p对象的属性中 
    Map<String,String> phone = new HashMap<String,String>(); 
    phone.put("office","8383838"); 
    p.setPhone(phone); 
     
    //建立地址对象，设置城市名 
    Address address = new Address(); 
    address.setCity("北京"); 
    Address[] addresses = {address}; 
    p.setAddress(addresses); 
    user.setProfile(p); 
    %> 
    <!-- 用JSP EL的级连方式输入值 --> 
    <!-- 输出user对象中的username属性值,三种写法等价 --> 
    ${user.userName }<br> 
    ${user["userName"] }<br> 
    ${user['userName'] }<br> 
    <!-- 输出user对象中profile属性对象中的phone属性Map中键值为office的值 --> 
    ${user.profile.phone.office }<br> 
    ${user['profile']['phone']['office'] }<br> 
    <!-- 输出user对象中profile属性对象中address数据属性中第0个元素对象中的city的属性值 --> 
    ${user.profile.address[0].city }<br> 
  </body> 
</html> 
