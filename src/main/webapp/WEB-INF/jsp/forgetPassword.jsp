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
	var account;
	function sendSMSValidationCode() {
		if ($("#acct").val() == null || $("#acct").val() == "") {
			alert("账号不能为空！");
			$("#acct").focus();
			return;
		}
		account = $("#acct").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/findUserMobileByAccount",
			type : "POST",
			data : "account=" + account,
			dataType : "json",
			success : function(data) {
				$.ajax({
					url : "${pageContext.request.contextPath}/sendSMSValidationCode",
					type : "POST",
					data : "mobile=" + data,
					success : function() {
						alert("短信口令已发送至您的手机上，请查收！");
						$("#accountDiv").attr("style", "display:none");
						$("#SMSValidationCodeDiv").attr("style", "display:block");
						$("#SMSValidationCode").focus();
					},
					error : function() {
						alert("短信口令发送失败！");
						localhost.href="${pageContext.request.contextPath}/toForgetPassword";
					}
				});
			},
			error : function() {
				alert("用户不存在，请重新输入！");
				$("#acct").focus();
			}
		});
	}
	
	function checkSMSValidationCode() {
		var userValidationCode = $("#SMSValidationCode").val();
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/checkValidationCode",
			data:"userValidationCode="+userValidationCode,
			success:function(data){
				if(data=="true"){
					$("#SMSValidationCodeDiv").attr("style", "display:none");
			        $("#resetPasswordDiv").attr("style", "display:block");
				}
				if(data=="false"){
					alert("口令错误，请重新输入！");
		            $("#SMSValidationCode").focus();
		            return;
				}
			}
		});
	}
	
	function resetPassword() {
		var pwd = $("#pwd").val();
		if (pwd == null || pwd=="") {
			alert("新密码不能为空，请重新输入!");
			$("#pwd").focus();
			return;
		}
		var repwd = $("#repwd").val();
		if(repwd==null||repwd==""){
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
			url : "${pageContext.request.contextPath}/resetPassword",
			type : "POST",
			data : {"account":account,"password":pwd},
			success : function(data) {
				if(data==0){
					alert("密码修改失败！请重新修改！");
	                location.href = "${pageContext.request.contextPath}/toForgetPassword";
	                return;
				}
				alert("密码修改成功！请重新登录！");
                location.href = "${pageContext.request.contextPath}/login.jsp";
				
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
		<form action="${pageContext.request.contextPath}/resetPassword"
			class="form-horizontal" id="resetPasswordForm"
			name="resetPasswordForm" method="post">
			<div class="form-group" id="accountDiv">
				<label for="">请输入账号：</label> <input class="form-control" id="acct"
					name="acct" placeholder="请输入账号" />
				<button type="button" class="btn btn-default"
					onclick="sendSMSValidationCode()">确认</button>
			</div>
			<div class="form-group" id="SMSValidationCodeDiv" style="display: none">
				<label for="">请输入短信口令：</label> 
				<input class="form-control" id="SMSValidationCode" name="SMSValidationCode"
					placeholder="请输入短信口令" />
				<button type="button" class="btn btn-default" id="chekSMSValidationCodeButton"
					onclick="checkSMSValidationCode()">确认</button>
			</div>
			<div class="form-group" id="resetPasswordDiv" style="display: none">
				<div>
					<label for="">请输入新密码：</label> <input class="form-control"
						id="pwd" name="pwd" placeholder="请输入新密码" />
				</div>
				<div>
					<label for="">请再次输入新密码：</label> <input class="form-control"
						id="repwd" name="repwd" placeholder="请再次输入密码" />
				</div>
				<div>
					<button type="button" id="resetPasswordButton"
						onclick="resetPassword()">确认</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>