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
	function sendSMSCode() {
		if ($("#user_account").val() == null || $("#user_account").val() == "") {
			alert("账号不能为空！");
			$("#user_account").focus();
			return;
		}
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/resetPwd_sendSMSCode",
			data : "user_account=" + $("#user_account").val(),
			success : function(data) {
				$("#accountDiv").css("display", "none");
				$("#SMSCodeDiv").css("display", "block");
				$("#user_SMSCode").focus();
			},
			error : function() {
				alert("用户不存在或手机号不存在，请重新输入！");
				$("#acct").focus();
			}
		});
	}

	function checkUserSMSCode() {
		if ($("#user_SMSCode").val() == null || $("#user_SMSCode").val() == "") {
			alert("口令不能为空！");
			$("#user_SMSCode").focus();
			return;
		}
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/checkUserSMSCode",
			data : "user_SMSCode=" + $("#user_SMSCode").val(),
			success : function(data) {
				if (data == "true") {
					$("#SMSCodeDiv").css("display", "none");
					$("#resetPasswordDiv").css("display", "block");
				}
				if (data == "false") {
					alert("口令错误，请重新输入！");
					$("#user_SMSCode").focus();
				}
			}
		});
	}

	function resetPassword() {
		var pwd = $("#pwd").val();
		if (pwd == null || pwd == "") {
			alert("新密码不能为空，请重新输入!");
			$("#pwd").focus();
			return;
		}
		var repwd = $("#repwd").val();
		if (repwd == null || repwd == "") {
			alert("新密码不能为空，请重新输入!");
			$("#repwd").focus();
			return;
		}
		if (pwd != repwd) {
			alert("两次输入的密码不一致，请重新输入！");
			$("#pwd").empty();
			$("#repwd").empty();
			$("#pwd").focus();
			return;
		}
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/resetPassword",
			data : "password=" + pwd,
			success : function(data) {
				if (data == 0) {
					alert("密码修改失败！请重新修改！");
					location.href = "${pageContext.request.contextPath}/toForgetPassword";
					return;
				}
				alert("密码修改成功！请重新登录！");
				location.href = "${pageContext.request.contextPath}/index.jsp";
			},
			error : function() {
				alert("密码修改失败！请重新修改！");
			    location.href = "${pageContext.request.contextPath}/toForgetPassword";
			}
		});
	}
</script>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" id="resetPasswordForm" name="resetPasswordForm">
			<div class="form-group" id="accountDiv">
				<label for="">请输入账号：</label>
				<input type="text" class="form-control" id="user_account" name="user_account" placeholder="请输入账号" />
				<button type="button" class="btn btn-default" onclick="sendSMSCode()">确认</button>
			</div>
			<div class="form-group" id="SMSCodeDiv" style="display: none">
				<label for="">请输入短信口令：</label>
				<input type="text" class="form-control" id="user_SMSCode" name="user_SMSCode" placeholder="请输入短信口令" />
				<button type="button" class="btn btn-default" onclick="checkSMSCode()">确认</button>
			</div>
			<div class="form-group" id="resetPasswordDiv" style="display: none">
				<div>
					<label for="">请输入新密码：</label>
					<input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入新密码" />
				</div>
				<div>
					<label for="">请再次输入新密码：</label>
					<input type="password" class="form-control" id="repwd" name="repwd" placeholder="请再次输入新密码" />
				</div>
				<div>
					<button type="button" class="btn btn-default" onclick="resetPassword()">确认</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>