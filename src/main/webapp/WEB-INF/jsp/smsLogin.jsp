<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>江苏省普通高校招生考生信息查询系统</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css"></link>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
	$(function() {
		var user = "${sessionScope.user}";
		if (user == null) {
			alert("当前用户未登录，请重新登录！");
			location.href = "${pageContext.request.contextPath}/index.jsp";
			return;
		}
		$(document).keydown(function(event) {//回车事件绑定
            if (event.keyCode == "13") {
                $("button").click();
            }
        });
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/sendSMSCode",
			success : function() {
				alert("短信口令已发送至您的手机上，请查收！");
				$("#user_SMSCode").focus();
			},
			error : function() {
				alert("短信口令发送失败，请重新登录！");
				location.href = "${pageContext.request.contextPath}/index.jsp";
			}
		});
	});

	function checkForm() {
		var smsCode = $("#user_SMSCode").val();
		if (smsCode == null || smsCode.length == 0) {
			alert("短信口令不能为空！");
			$("#user_SMSCode").focus();
			return;
		}
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/checkUserSMSCode",
			data : "user_SMSCode=" + $("#user_SMSCode").val(),
			success : function(data) {
				if ("false" == data) {
					alert("您输入的短信口令不正确，请重新输入！");
					$("#user_SMSCode").html("");
					$("#user_SMSCode").focus();
					return;
				}
				$("form").submit();
			},
			error : function() {
				alert("短信口令核对失败，请重新登录！");
				location.href = "${pageContext.request.contextPath}/index.jsp";
			}
		});
	}
</script>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" id="SMSLoginForm" name="SMSLoginForm" action="${pageContext.request.contextPath}/SMSLogin" method="post">
			<div class="form-group">您好，欢迎您：${user.userName}</div>
			<div class="form-group">
				<label for="">请输入短信口令：</label>
				<input type="text" class="form-control" id="user_SMSCode" name="user_SMSCode" placeholder="请输入短信口令" />
				<button type="button" class="btn btn-default" onclick="checkForm()">登录</button>
			</div>
		</form>
	</div>
</body>
</html>