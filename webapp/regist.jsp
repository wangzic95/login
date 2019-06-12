<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body style="background: url(res/222.png);background-size:cover; ">
  <center>
    <div>
    <h1>注册</h1>
    <form action="RegistServlet" method="post">
		    请输入帐号：<input type="text" name="username"><br/>
		    请输入密码：<input type="password" name="password"><br/>
		    请确认密码：<input type="password" name="rpsw	"><br/>
	      <input type="submit" value="注册">
    </form>
   	<font color="red" size="2"> ${msg }</font>
    </div>
    </center>
  </body>
</html>
