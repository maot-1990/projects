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
<style>
.breadcrumb a:spannk {
	text-decoration: none;
}
body{  
    margin:0;  
}  
#progress {  
    position:fixed;  
    height: 2px;  
    background:#2085c5;  
    transition:opacity 500ms linear  
}  
#progress.done {  
    opacity:0  
}  
#progress span {  
    position:absolute;  
    height:2px;  
    -webkit-box-shadow:#2085c5 1px 0 6px 1px;  
    -webkit-border-radius:100%;  
    -webkit-animation:pulse 2s ease-out 0s infinite;  
    opacity:1;  
    width:150px;  
    right:-10px;  
}  

@-webkit-keyframes pulse {  
    30% {  
        opacity:.6  
    }  
    60% {  
        opacity:0;  
    }  
    100% {  
        opacity:.6  
    }  
}  
</style>
<script type="text/javascript">
	var headMineFlag = 1;
	$(function() {
		$(window).scroll(function() {
			var h = $(this).scrollTop();
			if (h > 50) {
				$(".head_index").find("a").addClass("color_white");
				$(".head_index").addClass("head_index_scroll");
				$(".head_mine").css("top", "18px");
			} else {
				$(".head_index").find("a").removeClass("color_white");
				$(".head_index").removeClass("head_index_scroll");
				$(".head_mine").css("top", "40px");
			}
		});
		setInterval("headMine()", 1000);
		
		$({property: 0}).animate({property: 100}, {  
            duration: 2000,  
            step: function() {  
                var percentage = Math.round(this.property);  
                $('#progress').css('width',  percentage+"%");  
                 if(percentage == 100) {  
                        $("#progress").addClass("done");//完成，隐藏进度条  
                 }  
            }  
		});  
	});
	function headMine() {
		if (headMineFlag == 1) {
			$(".head_mine").css("color", "#0088A8");
			headMineFlag = 0;
		} else {
			$(".head_mine").css("color", "#888888");
			headMineFlag = 1;
		}
	}
	
	function openLogin(){
		$(".openLoginQQ").show();
		$("body").append("<div class=\"dialog_shadow\"></div>");
	}
	function closeLogin(){
		$(".openLoginQQ").hide();
		$("body").find(".dialog_shadow").remove();
	}
</script>
<div id="progress">  
    <span></span>  
</div>  
<div style="position: absolute;right: 15%;width: 150px;">
	<c:if test="${user != null }">
		<div style="color: red;">欢迎登陆：${user.userName }</div>
	</c:if>
	<%-- <c:if test="${user == null }">
		<a href="<%=basePathHead%>user/login" style="color: red;" class="pointer">登录</a>
	</c:if> --%>
</div>
<div class="head_index" style="margin-top: 20px;">
	<div class="menu_index head_mine">
		影子微客
	</div>
	<span class="menu_index" style="padding-left: 28%;">
		<a id="index_1" href="<%=basePathHead%>" class="glyphicon glyphicon-home">首页</a>
	</span> 
	<span class="menu_index">
		<a id="index_2" href="<%=basePathHead%>viewInfo/live.html">畅谈人生</a>
	</span> 
	<span class="menu_index">
		<a id="index_4" href="<%=basePathHead%>viewInfo/tech.html">技术分享</a>
	</span> 
	<span class="menu_index">
		<a id="index_8" href="<%=basePathHead%>viewInfo/joke.html">开心一刻</a>
	</span> 
	<span class="menu_index">
		<a id="index_3" href="<%=basePathHead%>daily/word.html">生活语录</a>
	</span> 
	<span class="menu_index">
		<a id="index_6" href="<%=basePathHead%>message/board.html">留言版</a>
	</span> 
	<span class="menu_index">
		<a id="index_7" href="<%=basePathHead%>viewInfo/about.html">关于</a>
	</span> 
	<%-- <span class="menu_index">
		<a id="index_5" href="<%=basePathHead%>publishInfo/edit.html">信息发布</a>
	</span> --%>
</div>

<div class="openLoginQQ">
	<button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="closeLogin();">×</button>
	<iframe width="800" height="400" onscroll="0" style="frameborder:0;border:0;" src="https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101380946&redirect_uri=http://www.maotbbk.com/qqback&scope=get_user_info,do_like"></iframe>
</div>

<script>
	window._bd_share_config = {
		"common" : {
			"bdSnsKey" : {},
			"bdText" : "",
			"bdMini" : "2",
			"bdMiniList" : [ "weixin", "sqq", "tsina", "qzone", "renren",
					"tqq", "kaixin001", "tieba", "isohu", "tqf", "douban",
					"evernotecn", "ty", "fbook" ],
			"bdPic" : "",
			"bdStyle" : "0",
			"bdSize" : "16"
		},
		"slide" : {
			"type" : "slide",
			"bdImg" : "1",
			"bdPos" : "left",
			"bdTop" : "145"
		}
	};
	with (document)
		0[(getElementsByTagName('head')[0] || body)
				.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
				+ ~(-new Date() / 36e5)];
</script>




