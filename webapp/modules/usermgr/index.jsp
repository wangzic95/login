<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.sql.*"%>
<%@ page import="com.wzc.login.domain.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/subpage.css">
</head>
<body>
    <h1 class="callout">用户管理</h1>
    <h3><a href="insert.jsp">添加用户</a></h3>
    <div class="callout" style="text-align:center;">
        <table border="1px" width="100%">
            <tr>
                <td>ID</td>
                <td>用户名</td>
                <td>昵称</td>
                <td>密码</td>
                <td>性别</td>
                <td>手机号</td>
                <td>邮箱</td>
                <td>地址</td>
                <td>操作</td>
            </tr>
            <%
                List<User> uList = (List<User>)request.getAttribute("userList");
                if(uList==null){
                    request.getRequestDispatcher(request.getContextPath()+"/UserServlet?act=select").forward(request, response);
                }else{
                    for(User user:uList){
            %>
            <tr>
                <td><%=user.getUserid()%></td>
                <td><%=user.getUsername()==null?"":user.getUsername()%></td>
                <td><%=user.getNickname()==null?"":user.getNickname()%></td>
                <td><%=user.getPassword()==null?"":user.getPassword()%></td>
                <td><%=user.getGender()==null?"":user.getGender()%></td>
                <td><%=user.getPhone()==null?"":user.getPhone()%></td>
                <td><%=user.getEmail()==null?"":user.getEmail()%></td>
                <td><%=user.getAddress()==null?"":user.getAddress()%></td>
                <td><a href="${pageContext.request.contextPath}/UserServlet?act=toUpdatePage&userid=<%=user.getUserid()%>" style="margin:0 10px;">修改</a>
                    <a href="${pageContext.request.contextPath}/UserServlet?act=delete&userid=<%=user.getUserid()%>">删除</a>
                </td>
            </tr>
            <%}} %>
        </table>
        <%
            Object resultMSG = request.getSession().getAttribute("resultMSG");
            if(resultMSG!=null){
        %><script type="text/javascript">alert("<%=resultMSG.toString() %>")</script><%
                request.getSession().removeAttribute("resultMSG");
            }
        %>
    </div>
</body>
</html>
