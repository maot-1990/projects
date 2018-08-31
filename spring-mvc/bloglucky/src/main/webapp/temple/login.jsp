<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String pathHead = request.getContextPath();
	String basePathHead = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathHead + "/";
%>

<script type="text/javascript">
	function loginSubmit() {
		$.ajax({
			url:"<%=basePathHead %>user/login",
			type:"post",
			data:$("#login").serialize(),
			dataType:"json",
			success:function(data){
				if(data.success == "true"){
					window.location.reload();
				}else{
					dialog("warning",data.msg);
				}
			}
		});
	}
	
	function logingo(obj){
		$(obj).parent().parent().addClass("page-container-on");
		$(obj).hide();
		$("body").append("<div class=\"dialog_shadow\"></div>");
	}
	
	function closeLogin(obj){
		$(obj).parent().removeClass("page-container-on");
		$(obj).next().find("div").show();
		$("body").find(".dialog_shadow").remove();
	}
</script>
<div class="page-container">
	<button type="button" class="close" data-dismiss="alert" aria-hidden="true" style="padding: 15px 15px 0 0 ;" onclick="closeLogin(this);">×</button>
	<div style="padding: 0 0 65px 0;">
		<h1>登录</h1>
		<form id="login" class="login" method="post">
			<input type="text" name="userName" class="username login"
				placeholder="用户名"> <input type="password" name="pwd"
				class="password login" placeholder="密码"> <input type="text"
				name="code" class="login" style="display: none;" placeholder="验证码">
			<input type="hidden" name="type" class="login">
			<input type="button" style="background-color: #E63F00;" onclick="loginSubmit()" name="type" class="login" value="登陆" />
		</form>
		<c:if test="${user != null }">
			<div class="login_tip">欢迎登陆：${user.userName }</div>
		</c:if>
		<c:if test="${user == null }">
			<div class="login_tip" onclick="logingo(this);">登录</div>
		</c:if>
		
	</div>
</div>
