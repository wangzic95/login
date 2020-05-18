<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.sql.*"%>
<%@ page import="com.wzc.login.domain.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/subpage.css">
</head>
<body>
    <h1 class="callout">用户管理</h1>
    <h3><a href="${pageContext.request.contextPath}/pages/usermgr/insert.jsp" class="wzc-btn">添加用户</a></h3>
    <div class="" style="text-align:center;">
        <table class="wzc-table">
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>昵称</th>
                <th>密码</th>
                <th>性别</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>地址</th>
                <th>操作</th>
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
                <td><a href="${pageContext.request.contextPath}/UserServlet?act=toUpdatePage&userid=<%=user.getUserid()%>" style="margin:0 10px;">
                    <i class="fa fa-edit fa-fw"></i> 修改</a>
                    <a href="${pageContext.request.contextPath}/UserServlet?act=delete&userid=<%=user.getUserid()%>">
                        <i class="fa fa-trash fa-fw"></i> 删除</a>
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
