<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>江苏省普通高校招生考生信息查询系统</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css"></link>
<script type="text/javascript">
	$(function() {
		var user = "${sessionScope.user}";
		if (user == null) {
			alert("当前用户未登录，请重新登录！");
			location.href = "${pageContext.request.contextPath}/index.jsp";
			return;
		}
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/queryMenu",
			dataType : "json",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$("ul").append(
							"<li><a href=${pageContext.request.contextPath}/" + data[i].url+ ">"
									+ data[i].rightName + "</a></li>");
				}
			},
			error : function() {
				alert("获取菜单失败！请重新登录！");
				location.href = "${pageContext.request.contextPath}/index.jsp";
			}
		});
	});

	function queryScore() {
		if ($("#stuNum").val() == null || $("#stuNum").val() == "") {
			alert("请输入考生号或准考证号！");
			$("#stuNum").focus();
			return;
		}
		$("#res_score_div").empty();
		$("#res_score_div")
				.append(
						"<table class='table table-bordered'><tr></tr><tr></tr></table>");
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/queryScore",
			data : "stuNum=" + $("#stuNum").val(),
			dataType : "json",
			success : function(data) {
				$("tr:eq(0)").append("<td>考籍号</td>");
				$("tr:eq(0)").append("<td>考生号</td>");
				$("tr:eq(0)").append("<td>准考证号</td>");
				$("tr:eq(0)").append("<td>姓名</td>");
				$("tr:eq(0)").append("<td>科类</td>");
				$("tr:eq(0)").append("<td>语文</td>");
				$("tr:eq(0)").append("<td>数学</td>");
				$("tr:eq(0)").append("<td>外语</td>");
				//——————————附加分名称逻辑开始——————————
				var fjfmc = "附加分";
				switch (data.xxkm4mc) {
				case "历史":
					fjfmc = "语文附加分";
					break;
				case "物理":
					fjfmc = "数学附加分";
					break;
				}
				$("tr:eq(0)").append("<td>" + fjfmc + "</td>");
				//——————————附加分名称逻辑结束——————————
				$("tr:eq(0)").append("<td>政策性照顾分</td>");
				$("tr:eq(0)").append("<td>文理科奖励分</td>");
				$("tr:eq(0)").append("<td>体艺科奖励分</td>");
				//——————————体艺类总分名称逻辑开始——————————
				var tylzfmc = "体艺类文化总分";
				switch (data.bkkldm) {
				case "3":
				case "5":
				case "6":
					tylzfmc = "艺术类文化总分";
					break;
				case "4":
				case "7":
				case "8":
					tylzfmc = "体育类文化总分";
					break;
				}
				$("tr:eq(0)").append("<td>" + tylzfmc + "</td>");
				//——————————体艺类总分名称逻辑结束——————————
				//——————————文理类总分名称逻辑开始——————————
				var wllzfmc = "文理类总分";
				switch (data.bkkldm) {
				case "1":
				case "5":
				case "7":
					wllzfmc = "文科类总分";
					break;
				case "2":
				case "6":
				case "8":
					wllzfmc = "理科类总分";
					break;
				}
				$("tr:eq(0)").append("<td>" + wllzfmc + "</td>");
				//——————————文理类总分名称逻辑结束——————————
				//——————————选修科目名称逻辑开始——————————
				if (data.xxkm4mc != null && data.xxkm4mc != "") {
					$("tr:eq(0)").append("<td>" + data.xxkm4mc + "</td>");
				} else {
					$("tr:eq(0)").append("<td>" + "选修科目（一）" + "</td>");
				}
				if (data.xxkm5mc != null && data.xxkm5mc != "") {
					$("tr:eq(0)").append("<td>" + data.xxkm5mc + "</td>");
				} else {
					$("tr:eq(0)").append("<td>" + "选修科目（二）" + "</td>");
				}
				//——————————选修科目名称逻辑结束——————————
				$("tr:eq(1)").append("<td>" + data.kjh + "</td>");
				$("tr:eq(1)").append("<td>" + data.ksh + "</td>");
				$("tr:eq(1)").append("<td>" + data.zkzh + "</td>");
				$("tr:eq(1)").append("<td>" + data.xm + "</td>");
				var kl = "科类";
				switch (data.bkkldm) {
				case "1":
					kl = "文科";
					break;
				case "2":
					kl = "理科";
					break;
				case "3":
					kl = "艺术";
					break;
				case "4":
					kl = "体育";
					break;
				case "5":
					kl = "艺兼文";
					break;
				case "6":
					kl = "艺兼理";
					break;
				case "7":
					kl = "体兼文";
					break;
				case "8":
					kl = "体兼理";
					break;
				}
				$("tr:eq(1)").append("<td>" + kl + "</td>");
				$("tr:eq(1)").append("<td>" + data.km1 + "</td>");
				$("tr:eq(1)").append("<td>" + data.km2 + "</td>");
				$("tr:eq(1)").append("<td>" + data.km3 + "</td>");
				var fjf = "0";
				switch (data.xxkm4mc) {
				case "历史":
					fjf = data.km1fjf;
					break;
				case "物理":
					fjf = data.km2fjf;
					break;
				}
				$("tr:eq(1)").append("<td>" + fjf + "</td>");
				$("tr:eq(1)").append("<td>" + data.zgf + "</td>");
				$("tr:eq(1)").append("<td>" + data.jlfPtl + "</td>");
				$("tr:eq(1)").append("<td>" + data.jlfTyl + "</td>");
				$("tr:eq(1)").append("<td>" + data.tylwhzf + "</td>");
				$("tr:eq(1)").append("<td>" + data.ptlzf + "</td>");
				if (data.xxkm4dd != null && data.xxkm4dd != "") {
					$("tr:eq(1)").append("<td>" + data.xxkm4dd + "</td>");
				} else {
					$("tr:eq(1)").append("<td>——</td>");
				}
				if (data.xxkm5dd != null && data.xxkm5dd != "") {
					$("tr:eq(1)").append("<td>" + data.xxkm5dd + "</td>");
				} else {
					$("tr:eq(1)").append("<td>——</td>");
				}
			},
			error : function() {
				alert("查询无相关记录，请核对考生号或准考证号是否正确！");
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
				<label for="">请输入考生号或准考证号：</label>
				<input type="text" class="form-control" id="stuNum" name="stuNum" />
				<button type="button" class="button-default" onclick="queryScore()">成绩查询</button>
			</form>
		</div>
		<div class="form-group" id="res_score_div"></div>
	</div>
</body>
</html>