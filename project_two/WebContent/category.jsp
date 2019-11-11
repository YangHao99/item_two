<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stx.entity.Category,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类型管理主界面</title>
<link type="text/css" rel="stylesheet" href="/categorysystem/css/main.css" />
</head>
<body>
	<div>
		<div style="float:left;">
			<a href="/categorysystem/jumpcate">添加类型</a>
		</div>
		<div style="float:right;">
			<form action="" method="post">
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
			<% 
				ArrayList<Category> cates = (ArrayList<Category>)request.getAttribute("cates"); 
				if (cates != null && cates.size() > 0) {
					for (Category c : cates) {
			%>
			<tr>
				<td><%=c.getCid() %></td>
				<td><%=c.getCname() %></td>
				<td><%=c.getCtime() %></td>
				<td><a href="#">修改</a>&nbsp;&nbsp;<a href="#">删除</a></td>
			</tr>
			<% } } else { %>
			<tr>
				<td colspan="4">没有数据...</td>
			</tr>
			<% } %>
		</table>
	</div>
</body>
</html>