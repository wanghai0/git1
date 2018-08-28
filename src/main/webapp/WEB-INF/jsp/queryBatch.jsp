<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>江苏省普通高校招生考生信息查询系统</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css"></link>
<script type="text/javascript">
	var start = 0;
	$(function() {
		var user = "${sessionScope.user}";
		if (user == null) {
			alert("当前用户未登录，请重新登录！");
			location.href = "/login.jsp";
			return;
		}
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/queryMenu",
			dataType : "json",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$("#menuUl").append(
							"<li><a href=${pageContext.request.contextPath}/" + data[i].url+ ">"
									+ data[i].rightName + "</a></li>");
				}
			},
			error : function() {
				alert("获取菜单失败！请重新登录！");
				location.href = "/login.jsp";
			}
		});
	});

	function queryBatch2() {
		$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/queryBatch2",
				dataType : "json",
				success : function(data2) {
					$("#pageUl").empty();
					var resList = data2.list;
					for (var j = 0; j < resList.length; j++) {
						$("#res_data").append("<p>" + resList[j].ksh + "</p>");
					}
					$("#pageUl").append("<li id='startLi'><a href='#' aria-label='Previous'> <spanaria-hidden='true'>&laquo;</span></a></li>");
					for (var i = 1; i <= data2.pages; i++) {
						if (i <= 10) {
							$("#pageUl").append("<li><a href='javascript:queryBatchByPageNum("+i+")'>" + i + "</a></li>");
						} else {
							break;
						}
					}
					$("#pageUl").append("<li><a href='#' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li>");
					$("#pageInfo").show();
				},
				error : function() {
					alert("获取菜单失败！请重新登录！");
					location.href = "/login.jsp";
				}
				});
	}
	
	function queryBatchByPageNum(pageNum){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/queryBatch",
			data:"pageNum="+pageNum,
			dataType:"json",
			success:function(data){
				$("#res_data").empty();
				$("#pageUl").empty();
				var resList = data.list;
				for (var j = 0; j < resList.length; j++) {
                    $("#res_data").append("<p>" + resList[j].ksh + "</p>");
                }
				$("#pageUl").append("<li id='startLi'><a href='#' aria-label='Previous'><spanaria-hidden='true'>&laquo;</span></a></li>");
				var count=1;
				for (var i = pageNum; i <= data.pages; i++) {
					if(pageNum>=data.pages-10+1){
						for(var j=data.pages-9;j<=data.pages;j++){
							$("#pageUl").append("<li><a href='javascript:queryBatchByPageNum("+j+")'>" + j + "</a></li>");
						}
						break;
					}else{
						if(count<=10){
	                        $("#pageUl").append("<li><a href='javascript:queryBatchByPageNum("+i+")'>" + i + "</a></li>");
	                        count=count+1;
	                    }
	                    else {
	                        break;
	                    }
					}
                }
                $("#pageUl").append("<li><a href='#' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li>");
                $("#pageInfo").show();
			},
			error:function(){
				
			}
		});
	}
</script>
</head>
<body>
	<div class="container">
		<div class="form-group">
			<ul id="menuUl"></ul>
		</div>
		<div class="form-group">
			<form class="form-horizontal">
				<label for="">批量查询</label>
				<button type="button" class="button-default" onclick="queryBatch2()">批量查询2</button>
			</form>
		</div>
		<div id="res_data"></div>
		<div id="pageInfo" style="display: none">
			<nav aria-label="Page navigation">
			<ul class="pagination" id="pageUl"></ul>
			</nav>
		</div>
		<div class="form-group" id="res_div"></div>
	</div>
</body>
</html>