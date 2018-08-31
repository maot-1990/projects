<%@page import="com.pers.blog.util.Pager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int totalPage = 0;
	int pageSize = 0;
	int pageIndex = 0;
	int totalNum = 0;
	Pager pager = (Pager) request.getAttribute("pager");
	if(pager != null){
		totalPage = pager.getTotalPage();
		pageSize = pager.getPageSize();
		pageIndex = pager.getPageIndex();
		totalNum = pager.getTotalNum();
	}else{
		totalPage = 0;
		pageSize = 5;
		pageIndex = 1;
		totalNum = 0;
	}
	
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title id='Description'></title>
<style type="text/css">
.jump_text {
  float: right;
  margin: 0 5px;
  line-height: 33px;
}
</style>
<script type="text/javascript">
	function commonGoPageNum(pageIndex, pageSize){
		if(parseInt(pageIndex) <= parseInt('0') || parseInt(pageIndex) > parseInt('<%=totalPage %>')){
			return;
		}
		commonPageSearch(pageIndex, pageSize);
		$("nav li a").find("span").parent().css({"background-color":"white"});
		$("nav li a").find("span").parent().html($("nav li a").find("span").html());
		$("#pageIndex_"+pageIndex+"").html("<span style=\"color:white;\">"+pageIndex+"</span>");
		$("#pageIndex_"+pageIndex+"").css({"background-color":"#428bca"});
		$("#prevPage").removeClass("disabled");
		$("#nextPage").removeClass("disabled");
		
		$("#prevPage").find("a").attr("onclick","commonGoPageNum("+(parseInt(pageIndex)-1)+", "+pageSize+")");
		$("#nextPage").find("a").attr("onclick","commonGoPageNum("+(parseInt(pageIndex)+1)+", "+pageSize+")");
		
		if(pageIndex == 1){
			$("#prevPage").addClass("disabled");
			$("#nextPage").removeClass("disabled");
		}
		if(pageIndex == '<%=totalPage %>'){
			$("#prevPage").removeClass("disabled");
			$("#nextPage").addClass("disabled");
		}
	}
	$(function(){
		var index = '<%=pageIndex %>'; 
		$("#pageIndex_"+index+"").html("<span style=\"color:white;\">"+index+"</span>");
		$("#pageIndex_"+index+"").css({"background-color":"#428bca"});
		
	});
	function serachPageIndex(pageSize){
		var pageIndex = $("#serachPageIndex").val();
		if(pageIndex == ""){
			nerisInfo1("请输入跳转页码！")
			return;
		}
		if(pageIndex == "0"){
			nerisInfo1("请输入有效页码！");
			return;
		}
		var reg = /^[0-9]*$/;
		if(!reg.exec(pageIndex)){
			nerisWarning("请输入跳转的页码")
			return;
		}
		if(parseInt(pageIndex) > parseInt('<%=totalPage%>')) {
			nerisInfo1("请输入有效页码!");
			return;
		}
		commonGoPageNum(pageIndex, pageSize);
	}
</script>
	<nav>
		<ul class="pagination" style="margin-top:20px;">
			
			<%
				if (pageIndex <= 1) {
			%>
			<li class="disabled" id="prevPage"><a href="javascript:void(0);" class="glyphicon glyphicon-chevron-left"
				onclick="commonGoPageNum('<%=pageIndex - 1%>', '<%=pageSize%>');"></a></li>
			<%
				} else {
			%>
			<li id="prevPage"><a href="javascript:void(0);" class="glyphicon glyphicon-chevron-left"
				onclick="commonGoPageNum('<%=pageIndex - 1%>', '<%=pageSize%>');"></a></li>
			<%
				}
			%>
			<%
				if (totalPage <= 5) {

					for (int i = 1; i <= totalPage; i++) {
			%>
						<li><a href="javascript:void(0);" id="pageIndex_<%=i%>"
							onclick="commonGoPageNum('<%=i%>', '<%=pageSize%>');"><%=i%></a></li>
			<%
					}
				}
			%>
			<%
				if (totalPage >5) {
			%>
			<%
				if (pageIndex == 1) {
			%>
				<li><a href="javascript:void(0);" id="pageIndex_1"
				onclick="commonGoPageNum('1', '<%=pageSize%>');">1</a></li>
				<li><a href="javascript:void(0);" id="pageIndex_2"
				onclick="commonGoPageNum('2', '<%=pageSize%>');">2</a></li>
				
				<li><a href="javascript:void(0);" id="pageIndex_3"
				onclick="commonGoPageNum('3', '<%=pageSize%>');">3</a></li>
				<li><a href="javascript:void(0);" id="pageIndex_4"
				onclick="commonGoPageNum('4', '<%=pageSize%>');">4</a></li>
				<li><span>...</span></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=totalPage%>"
				onclick="commonGoPageNum('<%=totalPage%>', '<%=pageSize%>');"><%=totalPage%></a></li>
			<%
				}
			%>

			<%
				if (pageIndex == 2) {
			%>
				<li><a href="javascript:void(0);" id="pageIndex_1"
				onclick="commonGoPageNum('1', '<%=pageSize%>');">1</a></li>
				<li><a href="javascript:void(0);" id="pageIndex_2"
				onclick="commonGoPageNum('2', '<%=pageSize%>');">2</a></li>
				
				<li><a href="javascript:void(0);" id="pageIndex_3"
				onclick="commonGoPageNum('3', '<%=pageSize%>');">3</a></li>
				<li><a href="javascript:void(0);" id="pageIndex_4"
				onclick="commonGoPageNum('4', '<%=pageSize%>');">4</a></li>
				<li><span>...</span></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=totalPage%>"
				onclick="commonGoPageNum('<%=totalPage%>', '<%=pageSize%>');"><%=totalPage%></a></li>
			<%
				}
			%>

			<%
				if (pageIndex == 3) {
			%>
				<li><a href="javascript:void(0);" id="pageIndex_1"
				onclick="commonGoPageNum('1', '<%=pageSize%>');">1</a></li>
				<li><a href="javascript:void(0);" id="pageIndex_2"
				onclick="commonGoPageNum('2', '<%=pageSize%>');">2</a></li>
				
				<li><a href="javascript:void(0);" id="pageIndex_3"
				onclick="commonGoPageNum('3', '<%=pageSize%>');">3</a></li>
				<li><a href="javascript:void(0);" id="pageIndex_4"
				onclick="commonGoPageNum('4', '<%=pageSize%>');">4</a></li>
				<li><span>...</span></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=totalPage%>"
				onclick="commonGoPageNum('<%=totalPage%>', '<%=pageSize%>');"><%=totalPage%></a></li>
			<%
				}
			%>
			
			<%
				if (pageIndex > 3 && pageIndex < totalPage - 2) {
			%>
					<li><a href="javascript:void(0);" id="pageIndex_1"
						onclick="commonGoPageNum('1', '<%=pageSize%>');">1</a></li>
					<li><span>...</span></li>
			<%
					
					for(int i=(pageIndex-1); i<=(pageIndex + 1); i++){
			%>
				<li><a href="javascript:void(0);" id="pageIndex_<%=i%>"
				onclick="commonGoPageNum('<%=i%>', '<%=pageSize%>');"><%=i%></a></li>
			<%
					}
			%>
				<li><span>...</span></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=totalPage%>"
				onclick="commonGoPageNum('<%=totalPage%>', '<%=pageSize%>');"><%=totalPage%></a></li>
			<%
				}
			%>
			<%
				if (pageIndex == totalPage - 2) {
			%>
				<li><a href="javascript:void(0);" id="pageIndex_1"
				onclick="commonGoPageNum('1', '<%=pageSize%>');">1</a></li>
				<li><span>...</span></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=totalPage-3%>"
				onclick="commonGoPageNum('<%=totalPage-3%>', '<%=pageSize%>');"><%=totalPage-3%></a></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=totalPage-2%>"
				onclick="commonGoPageNum('<%=totalPage-2%>', '<%=pageSize%>');"><%=totalPage-2%></a></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=pageIndex-1%>"
				onclick="commonGoPageNum('<%=totalPage-1%>', '<%=pageSize%>');"><%=totalPage-1%></a></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=pageIndex%>"
				onclick="commonGoPageNum('<%=totalPage%>', '<%=pageSize%>');"><%=totalPage%></a></li>
			
			<%
				}
			%>
			
			<%
				if (pageIndex == totalPage - 1) {
			%>
				<li><a href="javascript:void(0);" id="pageIndex_1"
				onclick="commonGoPageNum('1', '<%=pageSize%>');">1</a></li>
				<li><span>...</span></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=pageIndex-2%>"
				onclick="commonGoPageNum('<%=pageIndex-2%>', '<%=pageSize%>');"><%=pageIndex-2%></a></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=pageIndex-1%>"
				onclick="commonGoPageNum('<%=pageIndex-1%>', '<%=pageSize%>');"><%=pageIndex-1%></a></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=pageIndex%>"
				onclick="commonGoPageNum('<%=pageIndex%>', '<%=pageSize%>');"><%=pageIndex%></a></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=pageIndex+1%>"
				onclick="commonGoPageNum('<%=pageIndex+1%>', '<%=pageSize%>');"><%=pageIndex+1%></a></li>
			
			<%
				}
			%>
			<%
				if (pageIndex == totalPage) {
			%>
				<li><a href="javascript:void(0);" id="pageIndex_1"
				onclick="commonGoPageNum('1', '<%=pageSize%>');">1</a></li>
				<li><span>...</span></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=pageIndex-3%>"
				onclick="commonGoPageNum('<%=pageIndex-3%>', '<%=pageSize%>');"><%=pageIndex-3%></a></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=totalPage-2%>"
				onclick="commonGoPageNum('<%=totalPage-2%>', '<%=pageSize%>');"><%=totalPage-2%></a></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=pageIndex-1%>"
				onclick="commonGoPageNum('<%=totalPage-1%>', '<%=pageSize%>');"><%=totalPage-1%></a></li>
				<li><a href="javascript:void(0);" id="pageIndex_<%=pageIndex%>"
				onclick="commonGoPageNum('<%=totalPage%>', '<%=pageSize%>');"><%=totalPage%></a></li>
			
			<%
				}
			}
			%>

			<%
				if (pageIndex < totalPage) {
			%>
			<li id="nextPage"><a href="javascript:void(0);" class="glyphicon glyphicon-chevron-right"
				onclick="commonGoPageNum('<%=pageIndex + 1%>', '<%=pageSize%>');"></a></li>
			<%
				} else {
			%>
			<li id="nextPage" class="disabled"><a href="javascript:void(0);" class="glyphicon glyphicon-chevron-right"
				onclick="commonGoPageNum('<%=pageIndex + 1%>', '<%=pageSize%>');"></a></li>
			<%
				}
			%>

			
		</ul>
		<div class="jump" style="margin-top: 20px;float: right;">
	            <%
	                if (totalNum == 0 ) {
	            %>
	            <span class="jump_text" style="cursor: not-allowed;">
	                <button type="button" disabled="disabled" class="btn btn-primary btn-xs" >GO</button>
	            </span>     
                <%
                    } else {
                %>
                <span class="jump_text">
                    <button type="button" onclick="serachPageIndex( '<%=pageSize%>');" class="btn btn-primary btn-xs">GO</button>
                </span> 
                <%
                    }
                %>
            <span class="jump_text">页</span>
            <span class="jump_text">
                <input type="text" style="width: 35px;line-height: 23px;" class="form-control2 " id="serachPageIndex" onkeyup="value=value.replace(/[^\d]/g,'')"
                       onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" >
            </span>         
            <span class="jump_text">共有<%=totalPage%>页，<%=totalNum %>条记录。跳到</span>
		</div>
	</nav>
