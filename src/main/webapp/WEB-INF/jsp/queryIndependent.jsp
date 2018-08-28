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
    
    function queryIndependent() {
        if($("#stuNum").val()==null||$("#stuNum").val()==""){
            alert("请输入考生号或准考证号！");
            $("#stuNum").focus();
            return;
        }
        $("#res_div").empty();
        $.ajax({
            type : "POST",
            url  : "${pageContext.request.contextPath}/queryIndependent",
            data : "stuNum=" + $("#stuNum").val(),
            dataType : "json",
            success : function(data) {
                var zzzsZykListMap=data.zzzsZykListMap;
                $("#res_div").empty();
                $("#res_div").append("<div id='ksInfoDiv'></div><div><table class='table table-bordered' id='resTab'></table></div>");
                $("#ksInfoDiv").append("<label>姓名："+data.kssj.xm+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生号："+data.kssj.ksh+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号："+data.kssj.zjhm+"</label>");
                $.each(zzzsZykListMap,function(i,n){
	                $("#resTab").append("<tr><td colspan='5'>自主录取</td></tr>");
	                $("#resTab").append("<tr><td>批次</td><td>院校</td><td>专业</td><td>是否服从其他专业</td></tr>");
	                creatData(n);
                });
            },error:function(){
                 alert("查询无相关记录，请核对考生号是否正确！");
                 $("#stuNum").focus();
            }
        });
        
        function creatData(n){
            $.each(n,function(a,b){
                var zydh1mcfx=b.zydh1mcfx!=null?b.zydh1mcfx:'';
                var zydh2mcfx=b.zydh2mcfx!=null?b.zydh2mcfx:'';
                var zydh3mcfx=b.zydh3mcfx!=null?b.zydh3mcfx:'';
                var zydh4mcfx=b.zydh4mcfx!=null?b.zydh4mcfx:'';
                var zydh5mcfx=b.zydh5mcfx!=null?b.zydh5mcfx:'';
                var zydh6mcfx=b.zydh6mcfx!=null?b.zydh6mcfx:'';
                var zyzyfc=b.zyzyfc=='1'?'是':"否";
                $("#resTab").append("<tr><td>"+"A"+"</td><td>"+b.yxdh+"<br/>"+b.yxmc+"</td><td><table class='table table-bordered'>"+
                "<tr><td>1</td><td>"+zydh1mcfx+"</td>"+
                "<tr><td>2</td><td>"+zydh2mcfx+"</td>"+
                "<tr><td>3</td><td>"+zydh3mcfx+"</td>"+
                "<tr><td>4</td><td>"+zydh4mcfx+"</td>"+
                "<tr><td>5</td><td>"+zydh5mcfx+"</td>"+
                "<tr><td>6</td><td>"+zydh6mcfx+"</td>"+
                "</table></td><td>"+zyzyfc+"</td><tr>")
            });
        }
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
                    onclick="queryIndependent()">自主录取志愿查询</button>
            </form>
        </div>
        <div class="form-group" id="res_div"></div>
    </div>
</body>
</html>