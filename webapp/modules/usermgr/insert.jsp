<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/subpage.css">
</head>
<body>
<h1 class="callout">新增用户信息</h1>
<div class="callout">
	<form action="${pageContext.request.contextPath}/UserServlet?act=insert" method="post" style="width:100%;text-align:center;">
		<table>
			<tr><td>用户名:</td><td><input name="username" ></td></tr>
			<tr><td>昵称:</td><td><input name="nickname" ></td></tr>
			<tr><td>密码:</td><td><input name="password" ></td></tr>
			<tr><td>性别:</td><td><input name="gender" ></td></tr>
			<tr><td>手机号:</td><td><input name="phone" ></td></tr>
			<tr><td>邮箱:</td><td><input name="email" ></td></tr>
			<tr><td>地址:</td><td><input name="address" ></td></tr>
			<tr><td colspan='2'><input type="submit" value="添加" style="width:100%;"></td></tr>
		</table>
	</form>
</div>

<%
	Object resultMSG = request.getSession().getAttribute("resultMSG");
	if(resultMSG!=null){
%><script type="text/javascript">alert("<%=resultMSG.toString() %>")</script><%
		request.getSession().removeAttribute("resultMSG");
	}
%>
</body>
</html>