String.prototype.replaceAll = function (FindText, RepText) {
    regExp = new RegExp(FindText, "g");
    return this.replace(regExp, RepText);
}

var getRootPath = function() {
	var strFullPath = window.document.location.href;
	var strPath = window.document.location.pathname;
	var pos = strFullPath.indexOf(strPath);
	var prePath = strFullPath.substring(0, pos);
	var postPath = strPath.substring(0, strPath.substr(1).indexOf(
			'/') + 1);
	if (0 < strFullPath.indexOf("://localhost")
			|| 0 < strFullPath.indexOf("://127.0.0.1")
			|| 0 < strFullPath.indexOf("://m.maotbbk.com")
	) {
		return prePath + postPath;
	} else {
		return prePath; // TODO:服务器上是return(prePath);
	}
}

var dialog = function(type, msg){
	var divType = "";
	if(type=="success"){
		divType = "alert-success";
	}else if(type=="warning"){
		divType = "alert-warning";
	}else if(type=="info"){
		divType = "alert-info";
	}else if(type=="danger"){
		divType = "alert-danger";
	}else{
		divType = "alert-info";
	}
	
	var div="<div class=\"dialog alert "+divType+" alert-dismissable\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button><h4>"+type+"!</h4><div style=\"padding: 15px 0 0 39px;\">"+
	msg +"</div></div>";
	
	var div_shadow="<div class=\"dialog_shadow\"></div>";
	
	$("body").append(div_shadow);
	$("body").append(div);
	$(".close").click(function(){
		$("body").find(".dialog_shadow").remove();
	});
}

