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
<title>留言板~影子微客</title>
<jsp:include page="../../../style/style.jsp"></jsp:include>
<script type="text/javascript">
	var replyStatus = true;
	var replyId = "";
	function commonPageSearch(pageIndex, pageSize){
		window.location.href="<%=basePath%>message/board.html?pageIndex="
					+ pageIndex;
	}
	$().ready(function() {
		$("#index_6").addClass("menu_active");
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
		
		
		$(".submit_borad").click(function(){
			var content = $(".submit_content").val();
			content = content.replaceAll("&nbsp;","");
			if(content == null || content == "" || content == "<span class=\"sumbit_content_tip\">留下足迹...</span>"){
				return;
			}
			content = encodeURI(content);
			$.ajax({
				url:"<%=basePath%>message/saveMessage",
				data : "type=1&content="
						+ content,
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
	//1:赞   2：踩
	function glyphiconThumbs(type, id, replyType) {
		var flag = true;
		$.ajax({
			url : "glyphiconThumbs",
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
			url : "reply",
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
		$(".reply_content_"+id).html("");
	}
	
	
	
</script>
</head>
<body>
	<jsp:include page="/temple/head.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-8 column">
				<div class="page-header">
					<h1>
						<span class="glyphicon glyphicon-envelope logoTitle">&nbsp;留言版</span>
					</h1>
				</div>

				<div style="margin: 0 0 10px 5px;">
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

				<div style="margin-bottom: 35px;">
					<textarea id="submit_content" class="submit_content"
						style="height: 140px; border: 1px solid #DDDDDD; width: 100%; padding: 15px 15px; overflow: auto; border-top-right-radius: 8px; border-top-left-radius: 8px;"></textarea>
				</div>
				<div id="Smohan_FaceBox">
						<a href="javascript:void(0)" class="face" title="表情"></a>
				</div>
				<div
					style="height: 38px; width: auto; margin-top: -36px; border: 1px solid #DDDDDD; border-top: none;; padding-left: 658px; position: inherit; border-bottom-right-radius: 8px; border-bottom-left-radius: 8px;">
					<div class="submit_borad"
						style="border-left: 1px solid #DDDDDD; height: 38px; padding: 9px 5px 9px 16px; background-color: #009FCC; border-bottom-right-radius: 8px; border-top-left-radius: 8px; color: white;">
						提交留言</div>
				</div>
				
				<div style="height: 35px;padding:6px 0 0 10px;margin: 15px 0 0 0;border-top-left-radius: 6px;border-top-right-radius: 6px;border: 1px solid #DDDDDD;border-bottom: none;"><span style="font-size: 16px;">留言</span>(<span style="color: red;">${pager.totalNum}</span>)</div>

				<c:forEach items="${page}" var="board" varStatus="status">
					<div class="panel panel-default" style="margin-bottom: 6px;">
						<div class="panel-body" style="height: auto;">

							<div style="float: left;">
								<c:choose>
									<c:when
										test="${board.headImgUrl == null || board.headImgUrl == '' }">
										<img src="<%=basePath%>images/base/default_head.jpg"
											style="border-radius: 10px;"
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
											style="height: 38px; width: auto; margin-top: -36px; border: 1px solid #DDDDDD; border-top: none;; padding-left: 550px; border-bottom-right-radius: 8px; border-bottom-left-radius: 8px;">
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
														style="border-radius: 10px;"
														width="40" height="40"
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
														style="height: 38px; width: auto; margin-top: -36px; border: 1px solid #DDDDDD; border-top: none;; padding-left: 439px; border-bottom-right-radius: 8px; border-bottom-left-radius: 8px;">
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
			<div class="col-md-4 column">
				<div
					style="margin-top: 195px; width: 360px; height: 40px; border: 1px solid #DDDDDD; border-bottom: none; padding: 10px 0 0 15px; border-top-left-radius: 8px; border-top-right-radius: 8px;">
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

			</div>
		</div>
	</div>
	<jsp:include page="/temple/foot.jsp"></jsp:include>
</body>
</html>