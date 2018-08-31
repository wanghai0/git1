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
	function generateVerficationCode() {//生成验证码
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/generateVerficationCode",
			success : function(data) {
				$("#validationCodeLabel").css({
					fontFamily : "Fixedsys",
					letterSpacing : "5px",
					color : "#0ab000"
				});//设置字体、字体间距、字体颜色
				$("#validationCodeLabel").html(data);
			},
			error : function() {
				alert("验证码生成失败，请刷新页面后重试！");
			}
		});
	}

	function checkForm() {//表单验证
		if ($("#user_account").val() == null || $("#user_account").val() == "") {
			alert("账号不能为空！");
			$("#user_account").focus();
			return;
		}
		if ($("#user_password").val() == null
				|| $("#user_password").val() == "") {
			alert("密码不能为空！");
			$("#user_password").focus();
			return;
		}
		if ($("#user_validationCode").val() == null
				|| $("#user_validationCode").val() == "") {
			alert("验证码不能为空！");
			$("#user_validationCode").focus();
			return;
		}
		if ($("#user_validationCode").val() != $("#validationCodeLabel").html()) {
			alert("验证码输入错误，请重新输入");
			$("user_validationCode").val("");
			$("#user_validationCode").focus();
			return;
		}
		$("form").submit();
	}

	$(function() {
		generateVerficationCode();
		$("#user_account").focus();
		$(document).keydown(function(event) {//回车事件绑定
			if (event.keyCode == "13") {
				$("button").click();
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/login" method="post">
			<div class="form-group">
				<label for="">账号</label>
				<input type="text" class="form-control" id="user_account" name="user_account" placeholder="请输入账号">
			</div>
			<div class="form-group">
				<label for="">密码</label>
				<input type="password" class="form-control" id="user_password" name="user_password" placeholder="请输入密码">
			</div>
			<div class="form-group">
				<label for="">验证码</label>
				<input type="text" class="form-control" id="user_validationCode" name="user_validationCode" placeholder="请输入验证码">
				<label for="" id="validationCodeLabel" onclick="generateVerificationCode()"></label>
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-default" onclick="checkForm()">登录</button>
				<a href="${pageContext.request.contextPath}/toForgetPassword">忘记密码</a>
			</div>
		</form>
	</div>

</body>
</html>