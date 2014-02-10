<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Param</title>
</head>
<body>
<form method="post" action="param.jsp">
  <p>姓名：<input type="text" name="username" size="15" /></p>
  <p>密码：<input type="password" name="password" size="15" /></p>
  <p>性别：<input type="radio" name="sex" value="Male" checked/>男
       <input type="radio" name="sex" value="Female"  /> 女</p>
  <p>年龄：<input type="password" name="age" size="15" /></p>
  <p>兴趣：<input type="checkbox" name="habit" value="学习"/>学习
     <input type="checkbox" name="habit" value="运动"/>运动
     <input type="checkbox" name="habit" value="旅游"/>旅游 
     <input type="checkbox" name="habit" value="音乐"/>音乐 </p>
  <p>   <input type="submit" value="发送"/>
          <input type="reset" value="重置"/></p>
</form>
</body>
</html>	
