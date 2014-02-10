<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border=0 width="80%" align="center">
<tr><td>
<input type="button" value="新增用户" onclick="location='userAdd.jsp'"/>
</td>
</tr>
</table>
<table border=1 width="80%" align="center">
	<tr>
		<th>
			id
		</th>
		<th>
			用户名
		</th>
		<th>
			登陆名
		</th>
		<th>
			密码
		</th>
		<th>
			操作
		</th>
	</tr>

	<c:forEach var="dip" items="${userList}">
		<tr>
			<td>
				${dip.id}
			</td>
			<td>
				${dip.userName}
			</td>

			<td>
				${dip.loginName}
			</td>
			<td>
				${dip.pwd}
			</td>
			<td>
				<input value="更改" type="button" onclick="location='userInfo!update.do?userInfo.id=	${dip.id}'" />
				<input value="删除" type="button" onclick="location='userInfo!delete.do?userInfo.id=	${dip.id}'" />
			</td>
		</tr>
	</c:forEach>
</table>

