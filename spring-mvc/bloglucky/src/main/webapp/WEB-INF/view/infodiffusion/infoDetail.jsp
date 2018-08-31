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
<title>${articleInfo.title}~影子微客</title>
<jsp:include page="../../../style/style.jsp"></jsp:include>

<script type="text/javascript">
	var heart = false;
	var systemFlag = 1;
	$(document).ready(function(){
		
		$(".glyphicon-thumbs-up").click(function() {
			var replyType = $(this).attr("replyType");
			if ($(this).hasClass("color_red")) {
				//$(this).removeClass("color_red");
				return;
			} else {
				$(this).addClass("color_red");
			}
			var id = $(this).attr("data");
			var flag = glyphiconThumbs('1', id, replyType);
			if (flag == true) {
				$(this).next().html(parseInt($(this).next().html()) + 1);
			}
		});

		$(".glyphicon-thumbs-down").click(function() {
			var replyType = $(this).attr("replyType");
			if ($(this).hasClass("color_red")) {
				//$(this).removeClass("color_red");
				return;
			} else {
				$(this).addClass("color_red");
			}
			var id = $(this).attr("data");
			var flag = glyphiconThumbs('2', id, replyType);
			if (flag == true) {
				$(this).next().html(parseInt($(this).next().html()) + 1);
			}
		});
		$(".magnification").zoomImgRollover();
		/* 表情包 */
		$("a.face").smohanfacebox({
			Event : "click",	//触发事件	
			divid : "Smohan_FaceBox", //外层DIV ID
			textid : "submit_content" //文本框 ID
		});

		$(".board_content").each(function(){
			$(this).replaceface($(this).html());
		});
	});
	
	function submitMsg(msgId){
		var content = $(".submit_content").val();
		content = content.replaceAll("&nbsp;","");
		if(content == null || content == ""){
			return;
		}
		content = encodeURI(content);
		$.ajax({
			url:"<%=basePath%>message/saveMessage",
			data : "type=2&content="
					+ content+"&msgId="+msgId,
			type : "POST",
			dataType : "json",
			success : function(data) {
				if (data.success == "true") {
					window.location.reload();
				}else{
					dialog("warning",data.msg);
				}
			}
		});

	}
	
	function mylove(obj, id) {
		if (heart) {
			return;
		}
		heart = true;
		
		$(obj).removeClass("glyphicon-heart-empty");
		$(obj).addClass("glyphicon-heart");
		$(obj).css({
			"color" : "#FF3333"
		});
		
		$.ajax({
			url:"<%=basePath%>article/heart",
			type : "post",
			data : "id=" + id,
			dataType : "json",
			success : function(data) {
				if (data.success == "true") {
					$("#heartNum").html(parseInt($("#heartNum").html()) + 1);
				}
			}
		});
	}
	
	function commonPageSearch(pageIndex, pageSize){
		window.location.href="<%=basePath%>article/detail?id=${articleInfo.id}&detail=1&pageIndex="
					+ pageIndex;
	}
	
	//1:赞   2：踩
	function glyphiconThumbs(type, id, replyType) {
		var flag = true;
		$.ajax({
			url : "<%=basePath%>message/glyphiconThumbs",
			type : "POST",
			data : "id=" + id + "&type=" + type + "&replyType="+replyType,
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.success == "true") {
					
				} else {
					flag = false;
				}
			}
		});
		return flag;
	}
	
	var replyStatus = true;
	var replyId = "";
	function replyShow(id, obj) {
		$(".reply_div").hide();
		$(".reply_div").prev().css("color", "#DDDDDD");
		
		if(replyId == ""){
			replyId = id;
			$(obj).css("color", "#444444");
			$("#" + id).show();
			replyStatus = false;
		}else{
			if(replyId != id){
				$(obj).css("color", "#444444");
				$("#" + id).show();
				replyStatus = false;
			}else{
				if (replyStatus) {
					$(obj).css("color", "#444444");
					$("#" + id).show();
					replyStatus = false;
				} else {
					$(obj).css("color", "#DDDDDD");
					replyStatus = true;
					$("#" + id).hide();
				}
			}
			replyId = id;
		}
	}

	function replyInfo(id, userId, userName, obj) {
		var content = $(".reply_content_"+id).html();
		if (content == null || content == "") {
			dialog("warning","请输入回复内容");
			return;
		}
		$.ajax({
			url : "<%=basePath%>message/reply",
			type : "POST",
			data : "rmsgId=" + id + "&rcontent=" + content + "&buserId="
					+ userId + "&buserName=" + userName,
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.success == "true") {
					window.location.reload();
				} else {
					dialog("warning",data.msg);
				}
			}
		});
		$(obj).parent().parent().prev().css("color", "#DDDDDD");
		replyStatus = true;
		$("#" + id).hide();
		$(".reply_content").html("");
	}
</script>
</head>
<body>
	<jsp:include page="/temple/head.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix" style="margin-top: 15px;">
			<div class="col-md-8 column"
				style="border-top: 3px dashed #DDDDDD; border-right: 3px dashed #DDDDDD; padding: 5px 5px 0 0;">
				<h3 style="text-align: center;margin-bottom: 15px;">${articleInfo.title}</h3>
				<div style="text-align: center;margin-bottom: 45px;">
					<span style="margin-left: 15px;">发布时间：<fmt:formatDate
							value="${articleInfo.createTime}" pattern="yyyy-MM-dd" /></span> <span
						style="margin-left: 15px;">阅读量[${articleInfo.readingCount}]</span>
					<a class="glyphicon glyphicon-heart-empty"
						style="color:#333;margin-left: 15px; margin-top: 5px; font-size: 14px; text-decoration: none; cursor: pointer;"
						onclick="mylove(this,'${articleInfo.id}')"></a>[<span
						id="heartNum">${articleInfo.heart}</span>]
				</div>
				<p>
					<span>${articleInfo.content}</span>
				</p>
				
				<div style="padding-left: 40%;margin: 35px auto;">
					<div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a></div>
					<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"24"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
				</div>
				
				<div><span style="font-weight: 700;">版权声明：</span>若无注明，本文皆为“影子微客”原创，转载请保留文章出处。</div>
				<div style="border-top: 1px dashed #DDDDDD;">
					<c:choose>
						<c:when
							test="${user != null }">
							<img src="${user.headImgUrl }"
								style="margin: 29px 0 10px 0; border-radius: 10px; float: left;"
								width="40" height="40"
								class="media-object pageIndex" alt='' />
						</c:when>
						<c:otherwise>
							<img src="<%=basePath%>images/base/default_head.jpg"
						style="margin: 29px 0 10px 0; border-radius: 10px; float: left;"
						width="40" height="40"
						class="media-object pageIndex" alt='' />
						</c:otherwise>
					</c:choose>	
						
					<div style="padding: 48px 0 0 45px;">
						<span style="font-size: 16px;">社交账号登陆：</span>
						<a onclick="openLogin();" class="qq">.</a>QQ
					</div>
				</div>
				
				<div style="margin-bottom: 35px; margin-top: 10px;">
					<textarea class="submit_content" id="submit_content" 
						style="border-top-right-radius: 8px;border-top-left-radius: 8px;height: 140px; border: 1px solid #DDDDDD; width: 100%; padding: 15px 15px; overflow: auto;"></textarea>
				</div>
				
				<div id="Smohan_FaceBox">
						<a href="javascript:void(0)" class="face" title="表情"></a>
				</div>
				
				<div
					style="height: 38px; width: auto; margin-top: -36px; border: 1px solid #DDDDDD; border-top: none;; padding-left: 683px; position: inherit; border-bottom-right-radius: 8px; border-bottom-left-radius: 8px;">
					<div class="submit_borad" onclick="submitMsg('${articleInfo.id}');"
						style="border-left: 1px solid #DDDDDD; height: 38px; padding: 9px 5px 9px 16px; background-color: #009FCC; border-bottom-right-radius: 8px; border-top-left-radius: 8px; color: white;">
						提交评论</div>
				</div>

				<div
					style=" border-bottom: 1px dashed #DDDDDD; margin: 21px 0;">
					<div
						style="height: 35px; font-size: 16px; padding: 8px 0 0 5px;">评论(<span style="color:red;">${pager.totalNum}</span>)</div>
				</div>

				<c:forEach items="${page}" var="board" varStatus="status">
					<div class="panel panel-default" style="margin-bottom: 6px;">
						<div class="panel-body" style="height: auto;">

							<div style="float: left;">
								<c:choose>
									<c:when
										test="${board.headImgUrl == null || board.headImgUrl == '' }">
										<img src="<%=basePath%>images/base/default_head.jpg"
											style=" border-radius: 10px;"
											width="40" height="40"
											class="media-object pageIndex magnification" alt='' />
									</c:when>
									<c:otherwise>
										<img src="${board.headImgUrl }"
											style="border-radius: 10px;"
											width="40" height="40"
											class="media-object pageIndex magnification" alt='' />
									</c:otherwise>
								</c:choose>
							</div>
							<div style="margin-left: 80px;">
								<div class="board_title" style="color: #FF3333">${board.userName }</div>
								<div class="board_content">${board.content }</div>
								<div class="board_info">
									<span><fmt:formatDate value="${board.createTime }"
											pattern="yyyy-MM-dd" /></span> <span style="margin-left: 15px;"><span
										class="glyphicon glyphicon-thumbs-up" replyType="1" style="cursor: pointer;"
										data="${board.id }"></span>顶(<span id="board_praise">${board.praise }</span>)</span>
									<span style="margin-left: 15px;"><span
										class="glyphicon glyphicon-thumbs-down" replyType="1"
										style="cursor: pointer;" data="${board.id }"></span>踩(<span
										id="board_tread">${board.tread }</span>)</span> <span class="replyInfo"
										style="margin-left: 15px; cursor: pointer;"
										onclick="replyShow('${board.id }',this)">回复</span>
									<div class="reply_div" style="margin-top: 15px; display: none;" id="${board.id }">
										<div style="margin-bottom: 35px;">
											<div class="reply_content_${board.id }" contenteditable="true"
												style="height: 110px; border: 1px solid #DDDDDD; width: 100%; padding: 15px 15px; overflow: auto; border-top-right-radius: 8px; color: #444444; border-top-left-radius: 8px; outline: none;"></div>
										</div>

										<div
											style="height: 38px; width: auto; margin-top: -36px; border: 1px solid #DDDDDD; border-top: none;; padding-left: 575px; border-bottom-right-radius: 8px; border-bottom-left-radius: 8px;">
											<div class="replyInfo"
												onclick="replyInfo('${board.id }','${board.userId }','${board.userName }',this)"
												style="border-left: 1px solid #DDDDDD; height: 38px; padding: 9px 5px 9px 24px; background-color: #009FCC; border-bottom-right-radius: 8px; border-top-left-radius: 8px; color: white;">
												回&nbsp;&nbsp;复</div>
										</div>
									</div>
								</div>
							</div>
							<div style="padding: 15px 0 15px 0; margin-left: 77px;">
								<c:forEach items="${board.replys}" var="reply"
									varStatus="status">
									<div class="panel-body" style="height: auto;border-bottom: 1px dashed #DDDDDD;">
										<div style="float: left;">
											<c:choose>
												<c:when
													test="${reply.headImgUrl == null || reply.headImgUrl == '' }">
													<img src="<%=basePath%>images/base/default_head.jpg"
														style=" border-radius: 10px;"
														width="50" height="50"
														class="media-object pageIndex magnification" alt='' />
												</c:when>
												<c:otherwise>
													<img src="${reply.headImgUrl }"
														style=" border-radius: 10px;"
														width="40" height="40"
														class="media-object pageIndex magnification" alt='' />
												</c:otherwise>
											</c:choose>
										</div>
										<div style="margin-left: 80px;">
											<div class="board_title" style="color: #FF3333">${reply.ruserName }: @${reply.buserName }</div>
											<div class="board_content">${reply.rcontent }</div>
											<div class="board_info">
												<span><fmt:formatDate value="${reply.rcreateTime }"
														pattern="yyyy-MM-dd" /></span> <span style="margin-left: 15px;"><span
													class="glyphicon glyphicon-thumbs-up" replyType="2"
													style="cursor: pointer;" data="${reply.rId }"></span>顶(<span
													id="board_praise">${reply.rpraise }</span>)</span> <span
													style="margin-left: 15px;"><span
													class="glyphicon glyphicon-thumbs-down" replyType="2"
													style="cursor: pointer;" data="${reply.rId }"></span>踩(<span
													id="board_tread">${reply.rtread }</span>)</span> <span class="replyInfo"
													style="margin-left: 15px; cursor: pointer;"
													onclick="replyShow('${reply.rId }',this)">回复</span>
												<div class="reply_div" style="margin-top: 15px; display: none;"
													id="${reply.rId }">
													<div style="margin-bottom: 35px;">
														<div class="reply_content_${reply.rId }" contenteditable="true"
															style="height: 110px; border: 1px solid #DDDDDD; width: 100%; padding: 15px 15px; overflow: auto; border-top-right-radius: 8px; color: #444444; border-top-left-radius: 8px; outline: none;"></div>
													</div>

													<div
														style="height: 38px; width: auto; margin-top: -36px; border: 1px solid #DDDDDD; border-top: none;; padding-left: 466px; border-bottom-right-radius: 8px; border-bottom-left-radius: 8px;">
														<div class="replyInfo"
															onclick="replyInfo('${reply.rId }','${reply.ruserId }','${reply.ruserName }',this)"
															style="border-left: 1px solid #DDDDDD; height: 38px; padding: 9px 5px 9px 24px; background-color: #009FCC; border-bottom-right-radius: 8px; border-top-left-radius: 8px; color: white;">
															回&nbsp;&nbsp;复</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
				<jsp:include page="/temple/commonPage.jsp"></jsp:include>
				
			</div>
			<div class="col-md-4 column"
				style="border-top: 3px dashed #DDDDDD; padding-left: 15px; padding-top: 15px;">
				<div
					style="margin-top: 15px; width: 360px; height: 40px; border: 1px solid #DDDDDD; border-bottom: none; padding: 10px 0 0 15px; border-top-left-radius: 8px; border-top-right-radius: 8px;">
					<div class="glyphicon glyphicon-heart icon" style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">每日寄语</span>
				</div>
				<div
					style="width: 360px; height: 80px; border: 1px solid #DDDDDD; text-align: center; padding-top: 15px;">
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
									${item["title"] }</a> <br /> <span
									style="font-size: 12px; color: #AAAAAA; margin-top: 15px;"
									class="glyphicon glyphicon-time"><fmt:formatDate
										value="${item['createTime'] }" pattern="yyyy-MM-dd" /></span> <span
									style="font-size: 12px; color: #AAAAAA; margin-left: 10px; margin-top: 15px;"
									class="glyphicon glyphicon-eye-open">(${item['readingCount'] })</span>
							</div>
						</div>
					</div>
				</c:forEach>
				
				<div
					style="width: 360px; height: 40px; border: 1px solid #DDDDDD; border-bottom: none; padding: 10px 0 0 15px; margin-top: 15px; border-top-left-radius: 8px; border-top-right-radius: 8px;">
					<div class="glyphicon glyphicon-user icon" style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">最近访客</span>
				</div>
				<div
					style="width: 360px; height: auto; border: 1px solid #DDDDDD; padding: 10px 10px;">
					<c:forEach items="${recentUser}" var="user" varStatus="status">
						<img class="visiter" alt="" width="40" height="40"
							src="${user.headImgUrl }"> 
					</c:forEach>
				</div>

				<div
					style="width: 360px; height: 40px; border: 1px solid #DDDDDD; border-bottom: none; padding: 10px 0 0 15px; margin-top: 15px; border-top-left-radius: 8px; border-top-right-radius: 8px;">
					<div class="glyphicon glyphicon-link icon" style="margin-right: 15px;"></div>
					<span style="font-weight: 700; color: #007799; font-size: 14px;">友情链接</span>
				</div>
				<div
					style="width: 360px; height: auto; border: 1px solid #DDDDDD; padding: 15px 28px;">
					<c:forEach var="item" items="${firendLinks }">
						<a href="${item.siteLink }" target="_blank"
							style="padding: 0 15px 15px 0;">${item.siteName }</a> 
					</c:forEach>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="/temple/foot.jsp"></jsp:include>
</body>
</html>