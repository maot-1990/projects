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
<title>每日一句~影子微客</title>
<jsp:include page="../../../style/style.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function() {
	$("#index_3").addClass("menu_active");
	$(".magnification").zoomImgRollover();
});

function commonPageSearch(pageIndex, pageSize){
	window.location.href="<%=basePath%>daily/word.html?pageIndex="
				+ pageIndex;
}

function wordHover(obj){
	$(obj).next().addClass("demo_hover");
	$(obj).next().next().addClass("index_div_time_hover");
	$(obj).next().next().next().css("color","#008866");
}

function wordOut(obj){
	$(obj).next().removeClass("demo_hover");
	$(obj).next().next().removeClass("index_div_time_hover");
	$(obj).next().next().next().css("color","black");
}
</script>
</head>
<body>
	<jsp:include page="/temple/head.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix">
			<div class="page-header">
				<h1>
					<span class="glyphicon glyphicon-tint logoTitle">&nbsp;生活语录</span>
				</h1>
			</div>
			<div class="col-md-12 column" style="padding: 15px 15px;">
				<div
					style="border-left: 2px solid #DDDDDD; height: 100%; position: absolute; right: 240px;"></div>
				<c:forEach items="${page}" var="word" varStatus="status">
					<div>
						<blockquote style="height: 165px; width: 850px;border-top: 1px solid #DDDDDD;" class="index_div" onmouseover="wordHover(this);" onmouseout="wordOut(this);">
							<div style="float: left;">
								<img src="<%=basePath %>img/showImg?fileId=${word.imgUrl }"
									style=" border-radius: 10px;"
									width="180" height="135"
									class="media-object pageIndex magnification" alt='' />
							</div>
							<div style="margin: 15px 15px 15px 165px;">
								<p>${word.content }</p>
							</div>
						</blockquote>
						<div class="demo"></div>
						<div class="index_div_time">
							<fmt:formatDate value="${word.createTime }" pattern="yyyy-MM-dd"/> 
						</div>
						<div class="glyphicon glyphicon-time demo-five" style="background-color: white;"></div>
					</div>
				</c:forEach>

				<div style="max-width: 890px;">
					<!-- <div class="progress progress-striped active">
						<div class="progress-bar progress-success"></div>
					</div> -->
					<jsp:include page="/temple/commonPage.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
</html>