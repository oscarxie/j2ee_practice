<%@ page language="java" pageEncoding="UTF-8"%> 
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
    <!-- 以下为JSP EL的算术运算实例 --> 
    ${10+10 }<br> 
    ${10-10 }<br> 
    ${10*10 }<br> 
    ${10/10 }<br> 
    ${10 div 10 }<br> 
    ${10%10 }<br> 
    ${10 mod 10 }<br> 
    <!-- 以下为想输入原样的表达式，需要用\或者'进行转义 --> 
    \${10+10 }<br> 
    '$'{10+10 }<br> 
     
    <!-- 以下为JSP EL的关系运算实例 --> 
    ${100>200 }<br> 
    ${100 gt 200 }<br> 
    ${100<200 }<br> 
    ${100 lt 200 }<br> 
    ${100>=200 }<br> 
    ${100 ge 200 }<br> 
    ${100<=200 }<br> 
    ${100 le 200 }<br> 
    ${100==200 }<br> 
    ${100 eq 200 }<br> 
    ${100 !=200 }<br> 
    ${100 ne 200 }<br> 
    <!-- 以下为比较字符，字符用单引号，字符串用双引号引起 --> 
    ${'e' eq 'h' }<br> 
    ${"hit" > "him" }<br> 
     
    <!-- 以下为逻辑运算符的实例 --> 
    ${(10>2) && (34>25) }<br> 
    ${(10>2) and (34>25) }<br> 
    ${(10>2) || (34>25) }<br> 
    ${(10>2) or (34>25) }<br> 
    ${!(10>2)}<br> 
    ${not(10>2)}<br> 
     
    <!-- empty运算符的应用 empty判断时，若对象为""或是null，则都为true--> 
    <% 
      pageContext.setAttribute("username",null); 
      pageContext.setAttribute("password",""); 
      pageContext.setAttribute("city","北京"); 
      pageContext.setAttribute("date",new java.util.Date()); 
     %> 
     <!-- 判断username变量是否为空,以下返回true--> 
     ${empty username }<br> 
     <!-- 判断password变量是否为空，以下返回true --> 
     ${empty password }<br> 
     <!-- 判断city变量是否为空，以下返回false--> 
     ${empty city }<br> 
     <!-- 判断date变量是否为空，以下返回false --> 
     ${empty date }<br> 
     
  </body> 
</html> 
