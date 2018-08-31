<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String pathStyle = request.getContextPath();
	String basePathStyle = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathStyle + "/";
%>	

<%-- <link rel="stylesheet" type="text/css"
	href="<%=basePathStyle %>css/logon/reset.css" media="all">
<link rel="stylesheet" type="text/css"
	href="<%=basePathStyle %>css/logon/supersized.css" media="all"> --%>
<link rel="shortcut icon" type="image/x-icon" href="<%=basePathStyle %>images/base/favicon.ico" media="screen" />
	
<link rel="stylesheet" type="text/css"
	href="<%=basePathStyle %>css/smohan.face.css" media="all">	

<link rel="stylesheet" type="text/css"
	href="<%=basePathStyle %>thirdparty/uploadify3.2.1/uploadify.css" media="all">
<link rel="stylesheet" type="text/css"
	href="<%=basePathStyle %>css/skitter.styles.css" media="all">
<link rel="stylesheet" type="text/css"
	href="<%=basePathStyle %>css/style_header.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePathStyle %>css/navigation.css">
<link
	href="<%=basePathStyle %>thirdparty/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=basePathStyle %>css/base.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePathStyle %>css/color.css">

<script type="text/javascript" language="javascript"
	src="<%=basePathStyle %>thirdparty/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"></script>
<script type="text/javascript" language="javascript" src="<%=basePathStyle %>js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" language="javascript"
	src="<%=basePathStyle %>thirdparty/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePathStyle %>js/jquery.zoomImgRollover.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePathStyle %>js/jquery.easing.1.3.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePathStyle %>js/jquery.skitter.min.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePathStyle %>js/common.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePathStyle %>thirdparty/tinymce_4.5.0/tinymce.min.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePathStyle %>thirdparty/uploadify3.2.1/jquery.uploadify.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePathStyle %>js/smohan.face.js"></script>
<!-- 鼠标七彩星星效果 -->
<script type="text/javascript" src="http://cdn.txiaohe.cn/js/mymouse.js" id="mymouse"></script>

<!-- 登录页面 -->
<%-- <script type="text/javascript" language="javascript" src="<%=basePathStyle %>js/supersized.3.2.7.min.js"></script> --%>
<%-- <script type="text/javascript" language="javascript" src="<%=basePathStyle %>js/supersized-init.js"></script> --%>



<!--[if IE]>
	<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->