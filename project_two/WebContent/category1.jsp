<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stx.entity.Category,java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类型管理主界面</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" />
</head>
<body>
	<div>
		<div style="float:left;">
			<a href="/categorysystem/jumpcate">添加类型</a>
		</div>
		<div style="float:right;">
			<form action="${pageContext.request.contextPath }/querycate" method="post">
				<input type="text" name="cname" />
				<input type="submit" value="查询" />
			</form>
		</div>
		<div style="clear:both;"></div>
	</div>
	<div id="container">
		<table>
			<tr>
				<th>类型编号</th>
				<th>类型名称</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${cates }" var="ca" >
			<tr>
				<td>${ca.cid }</td>
				<td>${ca.cname }</td>
				<td><c:out value="${ca.ctime}" /></td>
				<td><a href="#">修改</a>&nbsp;&nbsp;<a href="#">删除</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<% 
			Category c = (Category)request.getAttribute("category"); 
			Integer cid = c.getCid();
			String cname = c.getCname();
			String ctime = c.getCtime();
		%>
		<!-- 类型对象的属性输出到页面上 -->
		<%=cid %>----<%=cname %>----<%=ctime %>
	</div>
	<div>
		${category.cid }----${category.cname }----${category.ctime }<br />
		${requestScope.category.cid }----${requestScope.category.cname }----${requestScope.category.ctime }
	</div>
	<div>
		<c:out value="<p>有特殊字符</p>" />
		<c:out value="<p>有特殊字符</p>" escapeXml="false" />
	</div>
</body>
</html>