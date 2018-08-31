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
<meta name="baidu-site-verification" content="507LUPiHu8" />
<meta name="baidu_union_verify" content="2d86177915ba559d13c0027776b46a59">
<meta name="baidu-site-verification" content="Tdd7aJquZE" />
<title>影子微客-个人网站，分享所见所得！</title>
<jsp:include page="../../style/style.jsp"></jsp:include>

<script type="text/javascript">
	var systemFlag = 1;
	$(document).ready(function() {
		$("#index_1").addClass("menu_active");
		$('.box_skitter_large').skitter({
			theme : 'clean',
			numbers_align : 'center',
			progressbar : true,
			dots : true,
			preview : true,
			interval:8000
		});
		$(".magnification").zoomImgRollover();
		systemDate();
		setInterval("systemDate()", 1000);
		setInterval('autoScroll(".newsInfo")',5000); 
	});

	function mouseOver(obj) {
		$(obj).parent().parent().removeClass("mouseout");
		$(obj).parent().parent().addClass("mouseover");
		$(obj).parent().next().removeClass("spanout");
		$(obj).parent().next().addClass("spanover");
	}

	function mouseOut(obj) {
		$(obj).parent().parent().removeClass("mouseover");
		$(obj).parent().parent().addClass("mouseout");
		$(obj).parent().next().removeClass("spanover");
		$(obj).parent().next().addClass("spanout");
	}

	function systemDate() {
		var date=new Date();  
		var yy=date.getFullYear();
		var MM=date.getMonth() + 1;
		if(MM<10){
			MM="0"+MM;
		}
		var dd=date.getDate();
		if(dd<10){
			dd="0"+dd;
		}
	    var hh=date.getHours();  
	    if(hh<10){
	    	hh="0"+hh;
		}
	    var mm=date.getMinutes();  
	    if(mm<10){
	    	mm="0"+mm;
		}
	    var ss=date.getSeconds();  
	    if(ss<10){
	    	ss="0"+ss;
		}
	    var week="";
	    switch (date.getDay()){
		    case 1: week="星期一"; break;
		    case 2: week="星期二"; break;
		    case 3: week="星期三"; break;
		    case 4: week="星期四"; break;
		    case 5: week="星期五"; break;
		    case 6: week="星期六"; break;
		    default:week="星期天"; break;
	    }
		if (systemFlag == 1) {
			$("#systemDate").css("color", "#444444");
			$("#systemInfo").css("color", "#0088A8");
			systemFlag = 0;
		} else {
			$("#systemDate").css("color", "#0088A8");
			$("#systemInfo").css("color", "#444444");
			systemFlag = 1;
		}
		$("#systemDate").html(yy+"-"+MM+"-"+dd+" "+hh+":"+mm+":"+ss+"    "+week);
	}
	
	function autoScroll(obj){  
		$(obj).find("ul").animate({  
			marginTop : "-40px"  
		},500,function(){  
			$(this).css({marginTop : "0px"}).find("li:first").appendTo(this);  
		});  
	}  
</script>
<style type="text/css">
.col-md-3 {
	width: 20%;
}

</style>

</head>
<body>
	<jsp:include page="/temple/head.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix" style="margin-top: 15px;">
			<div class="col-md-12 column">
			<div class="col-md-8 column"
				style="border-top: 3px dashed #DDDDDD; border-right: 3px dashed #DDDDDD; padding-top: 15px;">
				
				<div class="box_skitter box_skitter_large">
					<ul>
						<li><a href="#"><img src="<%=basePath %>images/banner/001.jpg"
								class="cube" /></a>
							<div class="label_text">
								<p>迎战2017</p>
							</div></li>
						<li><a href="#"><img
								src="<%=basePath %>images/banner/002.jpg" class="cubeRandom" /></a>
							<div class="label_text">
								<p>秋叶</p>
							</div></li>
						<li><a href="#"><img src="<%=basePath %>images/banner/003.jpg"
								class="block" /></a>
							<div class="label_text">
								<p>冬日雪景</p>
							</div></li>
						<li><a href="#"><img
								src="<%=basePath %>images/banner/004.jpg" class="cubeStop" /></a>
							<div class="label_text">
								<p>别致美</p>
							</div></li>
					</ul>
				</div>
				<div style="margin-top: 15px;border-bottom: 1px solid #DDDDDD;border-radius: 4px;"></div>
				<c:forEach var="item" items="${articleInfoList }">
					<div class="media index_div">
						<div class="media-body">
							<div class="media">
								<a href="#" class="pull-left"><img width="180" height="150"
									src="<%=basePath %>img/showImg?fileId=${item['imgUrl']}" class="media-object magnification"
									alt='' /></a>
								<div class="media-body" style="padding : 10px 0 0 10px;">
									<h4 class="media-heading" style="font-weight: 700;"><a class="title"
												href="<%=basePath %>article/detail?id=${item['id']}" target="_blank">${item["title"]}</a></h4>
									
									<span class="typeName">[${item["typeName"]}]</span>
									<span class="intro">&nbsp;&nbsp;&nbsp;&nbsp;发布时间：<fmt:formatDate value="${item['createTime']}"
											pattern="yyyy-MM-dd" /></span> 
									<span class="intro">&nbsp;&nbsp;&nbsp;&nbsp;阅读：[${item["readingCount"]}]</span>
									
									<div class="intro">${item["introduction"]}</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-md-4 column"
				style="border-top: 3px dashed #DDDDDD; padding-left: 15px; padding-top: 15px;">
				
				<div
					style="width: 360px; height: 40px; border: 1px solid #DDDDDD; padding: 10px 0 0 15px;border-bottom:none; border-top-left-radius:8px;border-top-right-radius:8px;">
					<div class="glyphicon glyphicon-certificate icon"
						style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">天气预报</span>
				</div>
				<div style="width: 360px;height: auto; border: 1px solid #DDDDDD; text-align: center; padding-top: 18px;">
					<iframe allowtransparency="true" frameborder="0" width="290"
						height="96" scrolling="no"
						src="http://tianqi.eastday.com/plugin/widget.html?sc=2&z=1&t=0&v=0&d=2&bd=0&k=000000&f=408080&q=1&a=1&c=54511&w=290&h=96&align=center"></iframe>
				
				</div>
	
				<div
					style="margin-top: 15px;width: 360px; height: 40px; border: 1px solid #DDDDDD; padding: 10px 0 0 15px;border-bottom:none; border-top-left-radius:8px;border-top-right-radius:8px;">
					<div class="glyphicon glyphicon-bullhorn icon"
						style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">最新动态</span>
				</div>
				<div style="width: 360px;height: auto; border: 1px solid #DDDDDD; text-align: left; padding-top: 18px;">
					<div class="newsInfo">
						<ul>
							<c:forEach var="info" items="${newsInfo }">
								<li><span><fmt:formatDate value="${info.createTime }" pattern="yyyy-MM-dd"/> &nbsp;&nbsp;${info.introduction }</span></li>  
					       	</c:forEach>
					    </ul> 
					</div>
				
				</div>

				<div
					style="margin-top: 15px;width: 360px; height: 40px; border: 1px solid #DDDDDD;border-bottom:none; padding: 10px 0 0 15px; border-top-left-radius:8px;border-top-right-radius:8px;">
					<div class="glyphicon glyphicon-heart icon"
						style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">每日寄语</span>
				</div>
				<div
					style="width: 360px;height: 80px; border: 1px solid #DDDDDD; text-align: center; padding-top: 15px;">
					<div id="dailyInfo" style="margin-top: 10px;">${daily.content }</div>
				</div>
				
				<div
					style="margin-top: 15px; width: 360px; height: 40px; border: 1px solid #DDDDDD; padding: 10px 0 0 15px; border-top-left-radius:8px;border-top-right-radius:8px;">
					<div class="glyphicon glyphicon-pencil icon" style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">推荐文章</span>
				</div>

				<c:forEach var="item" items="${hotClickList }">
					<div class="img_hover_hot"
						style="width: 360px; height: 120px; border: 1px solid #DDDDDD; padding: 10px 10px; border-top: none;">
						<div>
							<div style="float: left;">
								<img width="150" height="100" src="<%=basePath %>img/showImg?fileId=${item['imgUrl']}" alt=""
									border="0" class="magnification">
							</div>
							<div style="padding-left: 165px; padding-top: 15px;">
								<a class="a_hover" style="text-decoration: none;"
									href="<%=basePath %>article/detail?id=${item['id']}" target="_blank">
									${item["title"] }</a> <br /> <div
									style="font-size: 12px; color: #AAAAAA; margin-top: 15px;"
									class="glyphicon glyphicon-time"><fmt:formatDate
										value="${item['createTime'] }" pattern="yyyy-MM-dd" /></div> <div
									style="font-size: 12px; color: #AAAAAA; margin-left: 10px; margin-top: 15px;"
									class="glyphicon glyphicon-eye-open">(${item['readingCount'] })</div>
							</div>
						</div>
					</div>
				</c:forEach>
				
				<div
					style="margin-top: 15px;width: 360px; height: 40px; border: 1px solid #DDDDDD; padding: 10px 0 0 15px;border-bottom:none; border-top-left-radius:8px;border-top-right-radius:8px;">
					<div class="glyphicon glyphicon-calendar icon"
						style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">系统时间</span>
				</div>
				<div
					style="width: 360px;height: 80px; border: 1px solid #DDDDDD; text-align: center; padding-top: 15px;">
					<div id="systemDate" style="color: #007799;"></div>
					<div id="systemInfo" style="margin-top: 10px;">路漫漫其修远兮，吾将上下而求索！</div>
				</div>
				
				<div
					style="width: 360px; height: 40px; border: 1px solid #DDDDDD;border-bottom:none;  padding: 10px 0 0 15px; margin-top: 15px; border-top-left-radius:8px;border-top-right-radius:8px;">
					<div class="glyphicon glyphicon-user icon" style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">最近访客</span>
				</div>
				<div
					style="width: 360px;height: auto; border: 1px solid #DDDDDD; padding: 10px 10px;">
					<c:forEach items="${recentUser}" var="user" varStatus="status">
						<img class="visiter" alt="" width="40" height="40"
							src="${user.headImgUrl }"> 
					</c:forEach>
				</div>

				<div
					style="width: 360px; height: 40px; border: 1px solid #DDDDDD;border-bottom:none;  padding: 10px 0 0 15px; margin-top: 15px; border-top-left-radius:8px;border-top-right-radius:8px;">
					<div class="glyphicon glyphicon-link icon" style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">友情链接</span>
				</div>
				<div
					style="width: 360px;height: auto; border: 1px solid #DDDDDD; padding: 15px 28px;">
					<c:forEach var="item" items="${firendLinks }">
						<a href="${item.siteLink }" target="_blank"
							style="padding: 0 15px 15px 0;">${item.siteName }</a> 
					</c:forEach>
				</div>
				
				<div
					style="width: 360px; height: 40px; border: 1px solid #DDDDDD;border-bottom:none;  padding: 10px 0 0 15px; margin-top: 15px; border-top-left-radius:8px;border-top-right-radius:8px;">
					<div class="glyphicon glyphicon-leaf icon" style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">推广</span>
				</div>
				<div style="width: 360px;height: auto; border: 1px solid #DDDDDD; padding: 15px 28px;">
					<c:forEach var="item" items="${firendLinks }">
						<a href="${item.siteLink }" target="_blank"
							style="padding: 0 15px 15px 0;">${item.siteName }</a> 
					</c:forEach>
				</div>

			</div>
			</div>
		</div>
	</div>

	<div style="clear: both;"></div>
	<jsp:include page="/temple/foot.jsp"></jsp:include>
</body>
</html>