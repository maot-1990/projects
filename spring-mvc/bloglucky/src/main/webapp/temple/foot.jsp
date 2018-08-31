<%@page pageEncoding="UTF-8"%>
<%
	String footPath = request.getContextPath();
	String footBasePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ footPath + "/";
%>
<script type="text/javascript">
$(function() {
	$(window).scroll(function() {
		var h = $(this).scrollTop();
		if (h > 65) {
			$(".div_scroll").show();
			$(".div_wenxin").show();
		}else {
			$(".div_scroll").hide();
			$(".div_wenxin").hide();
		}
	});
 
	$(".div_scroll").click(function(){
		//window.scrollTo(0,0);
		$("body").animate({ scrollTop: 0 }, 600); 
	});
});
function showWenxinCode(){
	$(".wenxinCode").show();
}
function hideWenxinCode(){
	$(".wenxinCode").hide();
}

var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?535badbca7a2c25d3bc2500906fdc4f1";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();

(function(){
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';        
    }
    else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();

</script>
<div class="scroll_info">
	<div class="wenxinCode">
		<img alt="" src="<%=footBasePath %>images/base/wenxinCode.jpg">
	</div>
	<div class="div_wenxin" onmouseover="showWenxinCode();" onmouseout="hideWenxinCode();">
		<img alt="" src="<%=footBasePath %>images/base/wenxin.jpg">
	</div> 
	<div class="div_scroll glyphicon glyphicon-chevron-up"></div>
</div>
<div style="height: 55px;background-color: #DDDDDD;margin-top: 35px;text-align: center;padding-top:8px;width: 100%;">
	© Copyright Since 2017 maotbbk.com,All Right Reserved  <br />
	<a style="color: #333;" href="http://www.miitbeian.gov.cn/" target="_blank">京ICP备17001943号-1</a>
</div>
