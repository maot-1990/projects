<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<jsp:include page="./style/style.jsp"></jsp:include>
<script type="text/javascript">  
    var wsuri = "ws://localhost:8080/bloglucky/websocket";
	var ws = null;
	function startWebSocket() {
		if ('WebSocket' in window)
			ws = new WebSocket(wsuri);
		else if ('MozWebSocket' in window)
			ws = new MozWebSocket(wsuri);
		else
			console.error("not support WebSocket!");
		ws.onmessage = function(evt) {
			$('#returnMsg').html(evt.data);
			console.info(evt);
		};

		ws.onopen = function(evt) {
			alert("open");
			console.info(evt);
		};
		
		ws.onclose = function(evt) {

			alert("close");
			console.info(evt);
		};
	};

	function init() {
		startWebSocket();
	};
	init();

	function sendMsg() {
		ws.send(document.getElementById('writeMsg').value);
	}
	function closeScoket(){
		ws.close(1000, "Closing normally");
	}
</script>

</head>
<body>
<input type="text" id="writeMsg" />
<button onclick="sendMsg();">发送</button>

<button onclick="closeScoket();">关闭连接</button>

<div id="returnMsg"></div>
</body>
</html>
