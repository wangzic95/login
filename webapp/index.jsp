<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Object obj = request.getSession().getAttribute("user");
	if(obj==null){
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>主页</title>
	<link href="static/css/index.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<h1>管理系统</h1>
		<a href="LogoutServlet">退出登录</a>
		<span>当前用户：${sessionScope.user.username }</span>
	</div>
	<div class="sidebar">
		<ul>
			<li><a href="home.jsp" class="active" target="iframeContainer">后台首页</a></li>
			<li><a href="#">用户管理</a></li>
			<li><a href="#">系统管理</a></li>
			<li><a href="#">修改密码</a></li>
		</ul>
	</div>
	<div class="container">
		<iframe src="home.jsp" frameborder="0" height="100%" width="100%" name="iframeContainer"></iframe>
	</div>
</body>
</html>