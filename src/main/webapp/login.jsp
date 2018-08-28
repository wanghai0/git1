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
	var validationCode; // 全局 定义验证码

	function createValidationCode() { // 创建验证码函数
		validationCode = "";
		var codeLength = 4;// 验证码的长度
		var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c',
				'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');// 所有候选组成验证码的字符，当然也可以用中文的
		for (var i = 0; i < codeLength; i++) {
			var charIndex = Math.floor(Math.random() * 36);
			validationCode += selectChar[charIndex];
		}
		// 设置验证码的显示样式，并显示
		document.getElementById("validationCodeLabel").style.fontFamily = "Fixedsys"; // 设置字体
		document.getElementById("validationCodeLabel").style.letterSpacing = "5px"; // 字体间距
		document.getElementById("validationCodeLabel").style.color = "#0ab000"; // 字体颜色
		document.getElementById("validationCodeLabel").innerHTML = validationCode; // 显示
	}

	function checkValidationCode() {// 验证验证码输入是否正确
		var val1 = document.getElementById("validationCode").value;
		var val2 = validationCode;
		if (val1 != val2) {
			return false;
		}
		return true;
	}

	function checkForm() {
		if ($("#acct").val() == null || $("#acct").val() == "") {
			alert("账号不能为空！");
			$("#acct").focus();
			return;
		}
		if ($("#pwd").val() == null || $("#pwd").val() == "") {
			alert("密码不能为空！");
			$("#acct").focus();
			return;
		}
		if (!checkValidationCode()) {
			alert("验证码输入错误，请重新输入！");
            document.getElementById('validationCode').value = "";
            document.getElementById('validationCode').focus();
			return;
		}
		$("form").submit();
	}

	$(function() {
		createValidationCode();
		$("#acct").focus();
	});
</script>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/login"
			class="form-horizontal" id="loginForm" name="loginForm" method="post">
			<div class="form-group">
				<label for="">账号</label> <input class="form-control" id="acct"
					name="acct" placeholder="请输入账号">
			</div>
			<div class="form-group">
				<label for="">密码</label> <input type="password" class="form-control"
					id="pwd" name="pwd" placeholder="请输入密码">
			</div>
			<div class="form-group">
				<label for="">验证码</label> <input class="form-control"
					id="validationCode" name="validationCode" placeholder="请输入验证码">
				<label for="" id="validationCodeLabel"
					onclick="createValidationCode()"></label>
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-default" id="loginButton"
					onclick="checkForm()">登录</button>
				<a href="${pageContext.request.contextPath}/toForgetPassword">忘记密码</a>
			</div>
		</form>
	</div>
</body>
</html>