<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/home.css" />
</head>
<body>
	<style type="text/css">
table {
	border-collapse: collapse;
	margin: 0 auto;
	text-align: center;
}

table td, table th {
	border: 1px solid #cad9ea;
	color: #666;
	height: 30px;
}

table thead th {
	background-color: #CCE8EB;
	width: 100px;
}

table tr:nth-child(odd) {
	background: #fff;
}

table tr:nth-child(even) {
	background: #F5FAFA;
}
</style>
	<div id="logo">网站Logo展示${sessionScope.uid }---${uname }</div>
	<div id="menubar">菜单部分</div>
	<div id="content">
		<div id="info">
			<table>
				<tr>
					<td>用户名</td>
					<td>用户编号</td>
					<td>性别</td>
					<td>电子邮箱</td>
					<td>用户类型</td>
					<td>证件号</td>
					<td>注册时间</td>
				</tr>
				<tr>
					<td>${user.username}</td>
					<td>${user.usernumber}</td>
					<td>${user.sex}</td>
					<td>${user.email}</td>
					<td>${user.customertype}</td>
					<td>${user.certificatenumber}</td>
					<td>${user.ctime}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>