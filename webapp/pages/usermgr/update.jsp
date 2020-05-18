<%@ page import="com.wzc.login.domain.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/subpage.css">
</head>
<body>
<%
	User user = (User)request.getAttribute("updateUser");
%>
<h1 class="callout">用户信息修改</h1>
<div>
	<form action="${pageContext.request.contextPath}/UserServlet?act=update" method="post" style="width:100%;text-align:center;">
		<input name="userid" type="hidden" value='<%=user.getUserid() %>'>
        <table class="wzc-table">
			<tr>
                <th>用户名</th>
                <td><input name="username" type="text" readonly value='<%=user.getUsername()==null?"":user.getUsername()%>'></td>
                <th>昵称</th>
                <td><input name="nickname" type="text" value='<%=user.getNickname()==null?"":user.getNickname()%>'></td>
            </tr>
			<tr>
                <th>密码</th>
                <td><input name="password" type="text" value='<%=user.getPassword()==null?"":user.getPassword()%>'></td>
                <th>性别</th>
                <td><input name="gender" type="text" value='<%=user.getGender()==null?"":user.getGender()%>'></td>
            </tr>
			<tr>
                <th>手机号</th>
                <td><input name="phone" type="text" value='<%=user.getPhone()==null?"":user.getPhone()%>'></td>
                <th>邮箱</th>
                <td><input name="email" type="text" value='<%=user.getEmail()==null?"":user.getEmail()%>'></td>
            </tr>
			<tr>
                <th>地址</th>
                <td colspan="3">
                    <textarea name="address" rows="3" ><%=user.getAddress()==null?"":user.getAddress()%></textarea>
                </td>
            </tr>
            <tr>
                <td colspan='2'><input name="sub" type="submit" value="修改" class="wzc-btn" style="width: 200px;"></td>
                <td colspan='2'><a href="${pageContext.request.contextPath}/UserServlet?act=select" class="wzc-btn" style="width: 200px;">返回</a></td>
            </tr>
		</table>
	</form>
</div>
<%
	Object resultMSG = request.getSession().getAttribute("resultMSG");
	if(resultMSG!=null){
%>
<script type="text/javascript">
    alert("<%=resultMSG.toString() %>")
</script>
<%
		request.getSession().removeAttribute("resultMSG");
	}
%>
</body>
</html>