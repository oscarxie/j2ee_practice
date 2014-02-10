<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<html>
<head>
<title>param</title>
</head>
<body>
<h2>EL隐含对象 param、paramValues</h2>
  <fmt:requestEncoding value="GB2312" />
  <%request.setCharacterEncoding("gb2312"); %>
  姓名：${param.username}</br>
  密码：${param.password}</br>
  性别：${param.sex}</br>
  年龄：${param.age}</br>
  兴趣：${paramValues.habit[0]}  ${paramValues.habit[1]}
</body>
</html>
