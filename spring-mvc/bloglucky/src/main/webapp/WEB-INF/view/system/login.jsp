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
<title>登陆~影子微客</title>
<jsp:include page="../../../style/style.jsp"></jsp:include>
<script type="text/javascript">
function loginSubmit() {
	$.ajax({
		url:"<%=basePath%>user/goLogin",
			type : "post",
			data : $("#login").serialize(),
			dataType : "json",
			success : function(data) {
				if (data.success == "true") {
					window.location.href="<%=basePath%>";
				} else {
					dialog("warning", data.msg);
				}
			}
		});
	}

	function logingo(obj) {
		$(obj).parent().parent().addClass("page-container-on");
		$(obj).hide();
		$("body").append("<div class=\"dialog_shadow\"></div>");
	}

	function closeLogin(obj) {
		$(obj).parent().removeClass("page-container-on");
		$(obj).next().find("div").show();
		$("body").find(".dialog_shadow").remove();
	}
</script>
</head>
<body style="background-color: #DDDDDD;background-image: none;">
	<div style="width: 100%;height: 100%;text-align: center;">
		<div class="login">
			<form id="login" class="login" method="post" autocomplete="off">
				<input type="text" name="userName" class="username form-control"
					placeholder="用户名" style="position: absolute;top:380px;width: 282px;margin-left:261px;"> 
				<input type="password" class="password form-control" name="pwd"
				placeholder="密码" style="position: absolute;top:435px;width: 282px;margin-left:261px;"> 
				<input type="text"
					name="code" class="" style="display: none;" placeholder="验证码">
					
				<div class="goLogin" onclick="loginSubmit();"></div>
			</form>
	
		</div>
	</div>
</body>
</html>