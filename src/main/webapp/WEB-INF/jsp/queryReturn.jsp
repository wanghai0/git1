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
	$(function() {
		var user = "${sessionScope.user}";
		if (user == null) {
			alert("当前用户未登录，请重新登录！");
			location.href = "${pageContext.request.contextPath}/login.jsp";
			return;
		}
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/queryMenu",
			dataType : "json",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$("ul").append(
							"<li><a href=${pageContext.request.contextPath}/"+data[i].url+">"
									+ data[i].rightName + "</a></li>");
				}
			},
			error : function() {
				alert("获取菜单失败！请重新登录！");
				location.href = "${pageContext.request.contextPath}/login.jsp";
			}
		});
	});

	function queryReturn() {
		if ($("#stuNum").val() == null || $("#stuNum").val() == "") {
			alert("请输入考生号！");
			$("#stuNum").focus();
			return;
		}
		$("#res_div").empty();
		$("#res_div").append("<table class='table table-bordered'><tr></tr><tr></tr></table>");
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/queryReturn",
			data : "stuNum=" + $("#stuNum").val().trim(),
			dataType : "json",
			success : function(data) {
				$("tr:eq(0)").append("<td>考生号</td>");
				$("tr:eq(0)").append("<td>完成时间</td>");
				$("tr:eq(0)").append("<td>投档单位</td>");
				$("tr:eq(0)").append("<td>投档院校</td>");
				$("tr:eq(0)").append("<td>投档时间</td>");
				$("tr:eq(0)").append("<td>考生状态名称</td>");
				$("tr:eq(0)").append("<td>退档原因名称</td>");
				$("tr:eq(0)").append("<td>备注</td>");
				$("tr:eq(0)").append("<td>投档批次</td>");
				$("tr:eq(0)").append("<td>科类</td>");
				$("tr:eq(1)").append("<td>" + data.ksh + "</td>");
				$("tr:eq(1)").append("<td>" + data.wcsj + "</td>");
				$("tr:eq(1)").append("<td>" + data.tddw + "</td>");
				$("tr:eq(1)").append("<td>" + data.tdyx + "</td>");
				$("tr:eq(1)").append("<td>" + data.tdsj + "</td>");
				$("tr:eq(1)").append("<td>" + data.ksztmc + "</td>");
				$("tr:eq(1)").append("<td>" + data.tdyymc + "</td>");
				$("tr:eq(1)").append("<td>" + data.bz + "</td>");
				$("tr:eq(1)").append("<td>" + data.tdpc + "</td>");
				$("tr:eq(1)").append("<td>" + data.kl + "</td>");
			},
			error : function() {
				alert("查询无相关记录，请核对考生号是否正确！");
				$("#stuNum").focus();
			}
		});
	}
</script>
</head>
<body>
	<div class="container">
		<div class="form-group">
			<ul></ul>
		</div>
		<div class="form-group">
			<form class="form-horizontal">
				<label for="">请输入考生号：</label> <input class="form-control"
					id="stuNum" name="stuNum" placeholder="请输入考生号" />
				<button type="button" class="button-default" onclick="queryReturn()">退档原因查询</button>
			</form>
		</div>
		<div class="form-group" id="res_div"></div>
	</div>
</body>
</html>