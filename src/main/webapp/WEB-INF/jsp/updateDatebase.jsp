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
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/updateDateBase" enctype="multipart/form-data" method="post">
            <div class="form-group">
                <label for="">可以更新计划库（JHK）、院校代号库（YXDH）、考生数据库（KSSJ）、考生分数库（KSFS）、志愿库（ZYK）、征求志愿库（ZYK_ZQ）、直招士官志愿库（ZYK_HS）、自主招生志愿库（ZZZSZYK）、录取库（LQK）、退裆库（TDK）</label>
                <input type="file" id="file" name="file"/>
                <button type="submit">上传</button>
            </div>
        </form>
    </div>
</body>
</html>