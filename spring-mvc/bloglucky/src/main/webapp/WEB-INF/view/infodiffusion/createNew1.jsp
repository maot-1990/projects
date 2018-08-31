<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>信息发布~影子微客</title>
<jsp:include page="../../../style/style.jsp"></jsp:include>
<script>
	$(document).ready(function(){
		$("#index_5").addClass("menu_active");
	});
	tinymce.PluginManager.add('imageSelector', function(editor, url) {
	    editor.addButton('imageSelector', {
		    text: '图片上传',
	        icon: false,
	        onclick: function() {
	            editor.windowManager.open({
	            	file : '<%=basePath %>temple/file.jsp',
	                title: '图片上传',
	                buttons: [{
	                    text: 'Close',
	                    onclick: 'close'
	                },
	                {
	                    text: '确定',
	                    onclick: 'submit'
	                }],
	                onsubmit: function(e) {
	                 	var fileId =  $(".mce-window").find("iframe")[0].contentDocument.getElementById("fileId").value;
	                 	var imgUrl = "<%=basePath %>img/showImg?fileId=" + fileId;
	                 	editor.execCommand('mceInsertContent', false, '<img alt="" class="imgUpload" style="text-align:center;display: block;" src="' + imgUrl + '"/>');
	                }
	           	});
	        }
  		});
	});
	
	tinymce.init({
	         selector:'textarea',          //<textarea>中为编辑区域
	         theme: "modern",                  //主题
	         language: "zh_CN",                //语言 ，可自行下载中文
	     height: 500,
	     plugins: [                             //插件，可自行根据现实内容删除
	          "imageSelector advlist autolink lists charmap print preview hr anchor pagebreak spellchecker",
	          "searchreplace wordcount visualblocks visualchars fullscreen insertdatetime  nonbreaking",
	          "save table contextmenu directionality emoticons paste textcolor image"
	    ],
	    toolbar: "imageSelector insertfile undo redo | styleselect fontselect fontsizeselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | l      | print preview fullpage | forecolor backcolor image",                          //工具栏，可根据需求删除
	    style_formats: [                        //初始时提供的默认格式
	         {title: 'Bold text', inline: 'b'},
	         {title: 'Red text', inline: 'span', styles: {color: '#ff0000'}},
	         {title: 'Red header', block: 'h1', styles: {color: '#ff0000'}},
	         {title: 'Example 1', inline: 'span', classes: 'example1'},
	         {title: 'Example 2', inline: 'span', classes: 'example2'},
	         {title: 'Table styles'},
	         {title: 'Table row 1', selector: 'tr', classes: 'tablerow1'}
	     ]
	}); 
	
</script>
</head>
<body>
	<jsp:include page="/temple/head.jsp"></jsp:include>
	<div class="container" style="padding: 35px 35px;">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3>信息发布</h3>
				<form role="form" action="<%=basePath %>publishInfo/saveInfo" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="exampleInputEmail1">标题：</label><input
							type="text" name="title" class="form-control" id="title" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">文章简介：</label><input
							type="text" name="introduction" class="form-control" id="introduction" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">文章类型：</label><select
							type="text" name="type" class="form-control" id="type" >
								<option value="1">畅谈人生</option>
								<option value="2">技术分享</option>
								<option value="3">生活语录</option>
								<option value="4">开心一刻</option>
								<option value="5">最新动态</option>
								<option value="6">其他</option>
								
							</select>
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">文章类型：</label><input
							type="text" name="typeName" class="form-control" id="typeName" />
					</div>
					
					<div class="form-group">
						<label for="exampleInputFile">文章logo：</label><input type="file"
							id="fileData" name="fileData"/>
					</div>
					
					<div class="form-group">
						<label for="exampleInputFile">内容：</label><textarea
							id="content" name="content" rows="15"></textarea>
					</div>
					
					<button type="submit" class="btn btn-default">发布</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>