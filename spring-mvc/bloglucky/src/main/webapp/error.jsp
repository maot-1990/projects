<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>404 - 对不起，您查找的页面不存在！</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/error/main.css">
<!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
	<div id="wrapper">
		<a class="logo" href="/"></a>
		<div id="main">
			<header id="header">
				<h1>
					<span class="icon">!</span>404<span class="sub">page not
						found</span>
				</h1>
			</header>
			<div id="content">
				<h2>您打开的这个的页面不存在！</h2>
				<p>当您看到这个页面,表示您的访问出错,这个错误是您打开的页面不存在,请确认您输入的地址是正确的,如果是在本站点击后出现这个页面,请联系站长进行处理。影子微客站长感谢您的支持!</p>
				<div class="utilities">
					<a class="button right" href="#"
						onClick="history.go(-1);return true;">返回</a><a
						class="button right"
						href="http://wpa.qq.com/msgrd?v=3&uin=779396604&site=qq&menu=yes">联系站长</a>
					<div class="clear"></div>
				</div>
			</div>
			<div id="footer">
				<ul>
					<li><a href="<%=basePath %>">网站首页</a></li>

				</ul>
			</div>
		</div>
	</div>
</html>