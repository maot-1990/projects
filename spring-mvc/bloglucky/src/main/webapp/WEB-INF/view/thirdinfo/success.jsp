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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆成功~影子微客</title>
<jsp:include page="../../../style/style.jsp"></jsp:include>
<script type="text/javascript">
	var timerInterval = "";
	$(document).ready(function() {
		var timer = $("#timer").html();
		timerInterval = setInterval("setTimer()", 1000);
	});

	function closeLogin() {
		parent.location.reload();
	}
	function setTimer(){
		var timer = $("#timer").html();
		if(timer == 1){
			closeLogin();
			clearInterval(timerInterval);
		}else{
			$("#timer").html((parseInt(timer)-1));
		}
	}
</script>
</head>
<body class="login_success">
	<div style="text-align: center;margin-top: 170px;font-size: 16px;">
		<div style="font-size: 16px;"><span style="color: red;">${user.userName }</span>,欢迎登录影子微客！</div>
		<div style="margin-top: 15px;"><span id="timer" style="color: red;">5</span>秒后为你跳转至主页，<a onclick="closeLogin();">立即跳转</a></div>
	</div>	
</body>
</html>