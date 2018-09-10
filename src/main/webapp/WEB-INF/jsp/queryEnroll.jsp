<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		var user="${sessionScope.user}";
		if(user==null){
			alert("当前用户未登录，请重新登录！");
			location.href="${pageContext.request.contextPath}/login.jsp";
			return;
		}
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/queryMenu",
			dataType : "json",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$("ul").append("<li><a href=${pageContext.request.contextPath}/"+data[i].url+">"+ data[i].rightName + "</a></li>");
				}
			},
			error : function() {
				alert("获取菜单失败！请重新登录！");
				location.href="${pageContext.request.contextPath}/login.jsp";
			}
		});
	});
	
	function queryEnroll() {
		if($("#stuNum").val()==null||$("#stuNum").val()==""){
			alert("请输入考生号或准考证号！");
			$("#stuNum").focus();
			return;
		}
		$("#res_div").empty();
		$("#res_div").append("<table class='table table-bordered'><tr></tr><tr></tr></table>");
		$.ajax({
			type : "POST",
			url	 : "${pageContext.request.contextPath}/queryEnroll",
			data : "stuNum=" + $("#stuNum").val(),
			dataType : "json",
			success : function(data) {
				var zyfx="";
				if(data.zyfx!=null&&data.zyfx!=''){
					zyfx=" <br/>专业方向：（"+data.zyfx+")";
				}
				var lqk=(data.lqk);
				$("tr:eq(0)").append("<td>考生号</td>");
				$("tr:eq(0)").append("<td>姓名</td>");
				$("tr:eq(0)").append("<td>院校代号</td>");
				$("tr:eq(0)").append("<td>院校名称</td>");
				$("tr:eq(0)").append("<td>专业代号</td>");
				$("tr:eq(0)").append("<td>专业名称</td>");
				$("tr:eq(0)").append("<td>批次名称</td>");
				$("tr:eq(0)").append("<td>科类名称</td>");
				$("tr:eq(0)").append("<td>录取逻辑志愿号</td>");
				$("tr:eq(0)").append("<td>录取时间</td>");
				$("tr:eq(0)").append("<td>考生状态名称</td>");
				$("tr:eq(1)").append("<td>"+lqk.ksh+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.xm+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.yxdh+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.yxmc+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.zydh+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.zymc+zyfx+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.pcmc+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.klmc+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.lqljzyh+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.lqsj+"</td>");
				$("tr:eq(1)").append("<td>"+lqk.ksztmc+"</td>");
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
				<label for="">请输入考生号：</label> <input class="form-control" id="stuNum"
					name="stuNum" placeholder="请输入考生号"/>
				<button type="button" class="button-default" 
					onclick="queryEnroll()">录取查询</button>
			</form>
		</div>
		<div class="form-group" id="res_div"></div>
	</div>
</body>
</html>