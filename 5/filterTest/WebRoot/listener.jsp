<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
目前在线人数：<font color="red"><%=application.getAttribute("onLine")%></font><br>
退出会话:<form action="exit.jsp" method="post"><input type="submit" value="exit"></form>