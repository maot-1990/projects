<%@page import="com.pers.blog.system.listener.SessionListener"%>
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
<title>网站简介~影子微客</title>
<jsp:include page="../../../style/style.jsp"></jsp:include>
<style>
/* Custom Styles */
ul.nav-tabs {
	width: 185px;
	margin-top: 145px;
	border-radius: 4px;
	border: 1px solid #ddd;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
}

ul.nav-tabs li {
	margin: 0;
	border-top: 1px solid #ddd;
}

ul.nav-tabs li:first-child {
	border-top: none;
}

ul.nav-tabs li a {
	margin: 0;
	padding: 8px 16px;
	border-radius: 0;
}

ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover {
	color: #fff;
	background: #0088cc;
	border: 1px solid #0088cc;
}

ul.nav-tabs li:first-child a {
	border-radius: 4px 4px 0 0;
}

ul.nav-tabs li:last-child a {
	border-radius: 0 0 4px 4px;
}

ul.nav-tabs.affix {
	/* top: 30px; */ /* Set the top position of pinned element */
	
}

p {
	font-size: 16px !important;
	line-height: 28px;
}

h2 {
	font-family: KaiTi;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		siteTime();
		setInterval("siteTime()", 1000);
	});
	function siteTime() {
		var seconds = 1000
		var minutes = seconds * 60
		var hours = minutes * 60
		var days = hours * 24
		var years = days * 365
		var today = new Date()
		var todayYear = today.getFullYear()
		var todayMonth = today.getMonth()
		var todayDate = today.getDate()
		var todayHour = today.getHours()
		var todayMinute = today.getMinutes()
		var todaySecond = today.getSeconds()
		/* Date.UTC() -- 返回date对象距世界标准时间(UTC)1970年1月1日午夜之间的毫秒数(时间戳) 
		 year - 作为date对象的年份，为4位年份值
		 month - 0-11之间的整数，做为date对象的月份
		 day - 1-31之间的整数，做为date对象的天数
		 hours - 0(午夜24点)-23之间的整数，做为date对象的小时数
		 minutes - 0-59之间的整数，做为date对象的分钟数
		 seconds - 0-59之间的整数，做为date对象的秒数
		 microseconds - 0-999之间的整数，做为date对象的毫秒数 */
		var t1 = Date.UTC(2017, 00, 10, 08, 33, 48)
		var t2 = Date.UTC(todayYear, todayMonth, todayDate, todayHour,
				todayMinute, todaySecond)
		var diff = t2 - t1
		var diffYears = Math.floor(diff / years)
		var diffDays = Math.floor((diff / days) - diffYears * 365)
		var diffHours = Math.floor((diff - (diffYears * 365 + diffDays) * days)
				/ hours)
		var diffMinutes = Math.floor((diff - (diffYears * 365 + diffDays)
				* days - diffHours * hours)
				/ minutes)
		var diffSeconds = Math.floor((diff - (diffYears * 365 + diffDays)
				* days - diffHours * hours - diffMinutes * minutes)
				/ seconds)
		document.getElementById("siteTime").innerHTML = " " + diffYears
				+ " 年 " + diffDays + " 天 " + diffHours + " 小时 " + diffMinutes
				+ " 分钟 " + diffSeconds + " 秒"
	}
</script>

</head>
<body data-spy="scroll" data-target="#myScrollspy">
	<div class="container">
		<div class="row">
			<div class="col-xs-3" id="myScrollspy" style="margin-top: 65px;">
				<ul class="nav nav-tabs nav-stacked" data-spy="affix"
					data-offset-top="0">
					<li class="active"><a href="<%=basePath%>"
						style="cursor: pointer;">首页</a></li>
					<li><a href="#section-1">网站简介</a></li>
					<li><a href="#section-2">免责声明</a></li>
					<li><a href="#section-3">联系我们</a></li>
					<li><a href="#section-4">网站运行</a></li>
				</ul>
			</div>
			<div class="col-xs-9">
				<h2 id="section-1">网站简介</h2>
				<p>《影子微客》---个人博客网站</p>
				<hr>
				<h2 id="section-2">免责声明</h2>
				<p>
					1、《影子微客》部分文章信息来源于网络转载是出于传递更多信息之目的，并不意味着赞同其观点或证实其内容的真实性。如其他媒体、网站或个人从本网下载使用，必须保留本网注明的“稿件来源”，并自负版权等法律责任。如对稿件内容有疑议，请及时与我们联系。<br />
					2、《影子微客》致力于提供合理、准确、完整的资讯信息，但不保证信息的合理性、准确性和完整性，且不对因信息的不合理、不准确或遗漏导致的任何损失或损害承担责任。本网站所有信息仅供参考，不做交易和服务的根据，
					如自行使用本网资料发生偏差，本站概不负责，亦不负任何法律责任。<br />
					3、任何由于黑客攻击、计算机病毒侵入或发作、因政府管制而造成的暂时性关闭等影响网络正常经营的不可抗力而造成的损失，本网站均得免责。由于与本网站链接的其它网站所造成之个人资料泄露及由此而导致的任何法律争议和后果，本网站均得免责。<br />
					4、本网站如因系统维护或升级而需暂停服务时，将事先公告。若因线路及非本公司控制范围外的硬件故障或其它不可抗力而导致暂停服务，于暂停服务期间造成的一切不便与损失，本网站不负任何责任。<br />
					5、本网站使用者因为违反本声明的规定而触犯中华人民共和国法律的，一切后果自己负责，本网站不承担任何责任。<br />
					6、凡以任何方式登陆本网站或直接、间接使用本网站资料者，视为自愿接受本网站声明的约束。<br />
					7、本声明未涉及的问题参见国家有关法律法规，当本声明与国家法律法规冲突时，以国家法律法规为准。<br />
					8、本网站如无意中侵犯了哪个媒体或个人的知识产权，请来信或来电告之，本网站将立即给予删除。<br />
					9、为营造和谐友爱的网络环境，本网站有权删除不正当的评论和留言。<br />
				</p>
				<hr>
				<h2 id="section-3">联系我们</h2>
				<p>
					站长QQ：779396604 <br />
					联系地址： 北京市海淀区<br /> 
				</p>
				<hr>
				<h2 id="section-3">网站运行</h2>
				<p>
					备案号：${systemInfo.recordNumber }<br />
					今日ip：[<span style="color: red;">${todayIpMap.size()}</span>]<br />
					在线人数：[<span style="color: red;"><%=SessionListener.sessionMap.size() %></span>]<br />
					总访问量：[<span style="color: red;">${systemInfo.totalVisits }</span>]<br />
					影子微客：${systemInfo.siteUrl }<br /> 
					稳定运行： <span id="siteTime">${systemInfo.systemCreateTime }</span><br />
				</p>
				<hr>
			</div>
		</div>
	</div>
	<jsp:include page="/temple/foot.jsp"></jsp:include>
</body>
</html>