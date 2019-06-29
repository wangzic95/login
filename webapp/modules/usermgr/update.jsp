<%@ page import="com.wzc.login.domain.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/subpage.css">
</head>
<body>
<%
	User user = (User)request.getAttribute("updateUser");
%>
<h1 class="callout">用户信息修改</h1>
<div class="callout">
	<form action="${pageContext.request.contextPath}/UserServlet?act=update" method="post" style="width:100%;text-align:center;">
		<input name="userid" type="hidden" value="<%=user.getUserid() %>">
		<table>
			<tr><td>用户名:</td><td><input name="username" type="text" readonly value="<%=user.getUsername()==null?"":user.getUsername()%>"></td></tr>
			<tr><td>昵称:</td><td><input name="nickname" type="text" value="<%=user.getNickname()==null?"":user.getNickname()%>"></td></tr>
			<tr style="display: none;"><td>密码:</td><td><input name="password" type="text" value="<%=user.getPassword()==null?"":user.getPassword()%>"></td></tr>
			<tr><td>性别:</td><td><input name="gender" type="text" value="<%=user.getGender()==null?"":user.getGender()%>"></td></tr>
			<tr><td>手机号:</td><td><input name="phone" type="text" value="<%=user.getPhone()==null?"":user.getPhone()%>"></td></tr>
			<tr><td>邮箱:</td><td><input name="email" type="text" value="<%=user.getEmail()==null?"":user.getEmail()%>"></td></tr>
			<tr><td>地址:</td><td><input name="address" type="text" value="<%=user.getAddress()==null?"":user.getAddress()%>"></td></tr>
			<tr><td colspan='2'><input name="sub" type="submit" value="修改" style="width:100%;"></td></tr>
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