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
			url : "${pageContext.request.contextPath}/sendSMSValidationCode",
			type : "POST",
			data : "mobile=${sessionScope.user.mobile}",
			success : function() {
				alert("短信口令已发送至您的手机上，请查收！");
				$("#SMSValidationCode").focus();
			},
			error : function() {
				alert("短信口令发送失败，请重新登录！");
				location.href = "${pageContext.request.contextPath}/login.jsp";
			}
		});
	});

	function checkForm() {
		if (SMSValidationCode == null || SMSValidationCode.length == 0) {
			alert("短信口令不能为空！");
			$("#SMSValidationCode").focus();
			return;
		}
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/checkValidationCode",
			data : "userValidationCode=" + $("#SMSValidationCode").val(),
			success : function(data) {
				if (data == "false") {
					alert("您输入的短信口令不正确，请重新输入！");
					$("#SMSValidationCode").val("");
					$("#SMSValidationCode").focus();
					return;
				}
				$("form").submit();
			},
			error : function() {
				alert("短信口令核对失败，请重新登录！");
				location.href = "/login.jsp";
			}
		});
	}
</script>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/SMSLogin"
			class="form-horizontal" id="SMSLoginForm" name="SMSLoginForm"
			method="post">
			<div class="form-group">您好，欢迎您：${user.userName}</div>
			<div class="form-group">
				<label for="">请输入短信口令：</label> <input class="form-control"
					id="SMSValidationCode" name="SMSValidationCode"
					placeholder="请输入短信口令" />
				<button type="button" class="btn btn-default" id="SMSLoginButton"
					onclick="checkForm()">登录</button>
			</div>
		</form>
	</div>
</body>
</html>