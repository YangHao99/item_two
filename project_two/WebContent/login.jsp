<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<div>
		<c:if test="${msg != null }">
			<span style="color:red;">${msg }</span>
		</c:if>
		<c:if test="${msg1 != null }">
			<span style="color:red;">${msg1 }</span>
		</c:if>
	</div>
	<div>
		<form action="${pageContext.request.contextPath }/login" method="post">
			用户名:<input type="text" name="username" /><br />
			
			密码:<input type="password" name="pwd" /><br />
			<input type="submit" value="登录" />
		</form>
	</div>
</body>
</html>