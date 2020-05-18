<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Object obj = request.getSession().getAttribute("user");
	if(obj==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/app.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/font-awesome-4.7.0/css/font-awesome.min.css">
	<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
</head>
<body>
<div id="app">
    <div class="slidebar">
        <div class="slidebar-logo" >
            <div class="logo-icon"><i class="fa fa-cog fa-spin"></i></div>
            <span class="title">后台管理系统</span>
        </div>
        <ul class="slidebar-warpper">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/workbench.jsp" target="mainframe">
                    <i class="fa fa-home fa-fw fa-lg"></i>
                    <span>工作台</span></a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/UserServlet?act=select" target="mainframe">
                    <i class="fa fa-file-text-o fa-fw fa-lg"></i>
                    <span>用户管理</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="javascript:;">
                    <i class="fa fa-cog fa-fw fa-lg"></i>
                    <span>网站配置</span>
                    <i class="nav-more fa fa-chevron-right"></i>
                </a>
                <ul>
                    <li><a href="javascript:;" target="mainframe"><span>网站设置</span></a></li>
                    <li><a href="javascript:;" target="mainframe"><span>友情链接</span></a></li>
                    <li><a href="javascript:;" target="mainframe"><span>分类管理</span></a></li>
                    <li><a href="javascript:;" target="mainframe"><span>系统日志</span></a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a href="javascript:;">
                    <i class="fa fa-book fa-fw fa-lg"></i>
                    <span>系统管理</span>
                    <i class="nav-more fa fa-chevron-right"></i>
                </a>
                <ul>
                    <li><a href="javascript:;" target="mainframe"><span>菜单管理</span></a></li>
                    <li><a href="javascript:;" target="mainframe"><span>权限管理</span></a></li>
                    <li><a href="javascript:;" target="mainframe"><span>日志管理</span></a></li>
                </ul>
            </li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/LogoutServlet" ><i class="fa fa-sign-out fa-fw fa-lg"></i> <span>退出登录</span></a></li>
        </ul>
    </div>
    <div class="container">
        <div class="navbar">
            <div class="fold-btn" ><i class="fa fa-bars"></i></div>
            <a href="${pageContext.request.contextPath}/LogoutServlet"><i class="fa fa-sign-out fa-fw"></i> 退出登录</a>
            <span>当前用户：${sessionScope.user.username }</span>
        </div>
        <div class="container-main">
            <iframe name="mainframe" src="${pageContext.request.contextPath}/workbench.jsp" frameborder="0" class="iframe-full"></iframe>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        // nav收缩展开
        $('.nav-item>a').on('click',function(){
            if (!$('.nav').hasClass('nav-mini')) {
                if ($(this).next().css('display') == "none") {
                    //展开未展开
                    $('.nav-item').children('ul').slideUp(300);
                    $(this).next('ul').slideDown(300);
                    $(this).parent('li').addClass('nav-show').siblings('li').removeClass('nav-show');
                }else{
                    //收缩已展开
                    $(this).next('ul').slideUp(300);
                    $('.nav-item.nav-show').removeClass('nav-show');
                }
            }
        });
        //nav-mini切换
        $('.fold-btn').on('click',function(){
            $('.nav-item.nav-show').toggleClass('nav-show');
            // $('.nav-item').children('ul').removeAttr('style');
            $('.slidebar').toggleClass("fold");
            $('.fold-btn>.fa').toggleClass("fa-rotate-90");
        });
    });
</script>
</body>
</html>