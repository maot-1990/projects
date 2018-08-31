<%@page pageEncoding="UTF-8"%>
<%
	String uploadPath = request.getContextPath();
	String baseUploadPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ uploadPath + "/";
%>
<jsp:include page="../style/style.jsp"></jsp:include>
<script type="text/javascript">
	var maxFileSize = 10 * 1024 * 1024;  
	$(function() {
		$("#uploadImgTinymce").uploadify({
			'debug' : false, //开启调试    
			'auto' : true, //是否自动上传    
			'buttonText' : '选择照片', //按钮上的文字  
			'swf' : "../thirdparty/uploadify3.2.1/uploadify.swf",//flash      
			'queueID' : 'uploadfileQueue', //文件选择后的容器ID    
			'uploader' : '<%=baseUploadPath %>img/uploadImg', //后台action  
			'width' : '75', //按钮宽度  
			'height' : '24', //按钮高度  
			'multi' : true, //是否支持多文件上传，默认就是true  
			'fileObjName' : 'fileData',//后台接收的参数，如：使用struts2上传时，后台有get,set方法的接收参数  
			'fileTypeDesc' : '支持的格式：',//  可选择文件类型说明  
			'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png', //允许上传文件的类型  
			'fileSizeLimit' : maxFileSize, //文件上传的最大大小  
			'removeTimeout' : 1,
			//返回一个错误，选择文件的时候触发    
			'onSelectError' : function(file, errorCode, errorMsg) {
				switch (errorCode) {
				case -100:
					alert("上传的文件数量已经超出系统限制的"
							+ $('#file_upload').uploadify('settings',
									'queueSizeLimit') + "个文件！");
					break;
				case -110:
					alert("文件 ["
							+ file.name
							+ "] 大小超出系统限制的"
							+ $('#file_upload').uploadify('settings',
									'fileSizeLimit') + "大小！");
					break;
				case -120:
					alert("文件 [" + file.name + "] 大小异常！");
					break;
				case -130:
					alert("文件 [" + file.name + "] 类型不正确！");
					break;
				}
			},
			//检测FLASH失败调用    
			'onFallback' : function() {
				alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
			},
			'onSelect' : function(file) {
				$("#uploadDiv").text("正在上传...");
				$("#uploadDiv").show();
			},
			//上传到服务器，服务器返回相应信息到data里    
			'onUploadSuccess' : function(file, data, response) {
				var json = eval("(" + data + ")");
				$("#fileId").val(json.fileId);
				$("#uploadDiv").text("上传完毕...");
				var imgUrl = "<%=baseUploadPath %>img/showImg?fileId=" + json.fileId;
				$("#uploadDiv").html('<img alt="" style="padding: 15px 15px;" width="200" height="200" src="' + imgUrl + '"/>');
			},
			'onQueueComplete' : function(queueData) { //队列里所有的文件处理完成后调用  
				
			}
		});
	});
</script>
<div style="padding: 25px 25px;">
	<input type="file" id="uploadImgTinymce" name="fileData" />
	<input type="hidden" id="fileId" value="">
	<div id="uploadDiv" style="display: none;color: red;"></div>
	<div id="preView">
	
	</div>
</div>
