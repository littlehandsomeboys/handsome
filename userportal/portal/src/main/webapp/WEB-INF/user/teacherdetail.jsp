<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>老师的详细情况</title>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/teacher/teacherDetail.css">
<style type="text/css">

.search_button{
	border-radius:7px;
	background:#f5f5f5;
	margin:0 auto;
	width:100%;
	border-color:#DCDCDC;
	border:solid #acacac 1px;
}

</style>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.easyui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<img src="${obj.reserve2}" style="max-width:100%;">
		<div class="teacher-detail" >
			<h2 class="name">${obj.reserve5}
				<span class="level"> <c:if test="${obj.reserve6 == '0'}">普通</c:if>
					<c:if test="${obj.reserve6 == '1'}">专家</c:if>
				</span>
			</h2>
			<div class="item">
				<span class="title">个人简介:</span> <span class="detail">${obj.reserve0}</span>
			</div>
			<div class="item">
				<span class="title">学历:</span> <span class="detail">${obj.reserve7}</span>
			</div>
			<div class="item">
				<span class="title">执教经历:</span> <span class="detail">${obj.reserve4}</span>
			</div>
			<div class="item">
				<span class="title">证书:</span> <span class="detail">${obj.reserve3}</span>
			</div>
		</div>
		<button id="backBtn" type="button" class="search_button">返回老师列表</button>
	</div>
</body>
<script>
$(function(){
	$('#backBtn').click(function(){
		window.history.back();
	});
})
</script>
</html>


