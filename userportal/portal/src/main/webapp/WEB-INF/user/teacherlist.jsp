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
<title>查找老师</title>
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
<link rel="stylesheet" href="css/teacher/teacherList.css">
<style type="text/css">
</style>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.easyui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/juicer.js"></script>

</head>
<body>
<div class="container">
	<div class="form-group " sytle="width: 60%;">
	<div class="input-group">
	 	<input id="searchInput" type="text" class="form-control" placeholder="请输入老师姓名">
	 	<span class="input-group-btn">
        <button class="btn btn-default" type="button" id="search"> 搜索 </button>
      </span>
      </div>
	</div>
	<div class="teacher-list" id="teacherList">
	</div>
	<input type="hidden" id="currentPage" value="0"/>
	<input type="hidden" id="totalPage" />
	<button id="nextPageBtn"  type="button" class="center-button">查找更多老师</button>
</div>
</body>
<script>
$(function(){
	getHandler('teacher/api/teacherList.do?pageNo=1&pageSize=2&ecName=弗恩教育');
	
	$('#search').click(function(){
		$('#currentPage').val(0);
		var url = 'teacher/api/teacherList.do?pageNo=1&pageSize=2&ecName=弗恩教育&reserve5='
		+ $('#searchInput').val();
		getHandler(url);
	});
	$('#nextPageBtn').click(function(){
		var page = parsInt($('#currentPage').val()) + parsInt(1);
		var url = 'teacher/api/teacherList.do?pageNo=' + page + '&pageSize=2&ecName=弗恩教育&reserve5='
				+ $('#searchInput').val();
		getHandler(url);
	});
	function getHandler(url){
		$.ajax({
			type: 'GET',
			url: url,
			success: function(data){
				
				if(data.result == '0'){
					alert(JSON.stringify(data));
					$('#teacherList').append(juicer(document.getElementById('teacherList').innerHTML, data.rows));
					$('#totalPage').val(data.total);
					$('#currentPage').val(parsInt($('#currentPage').val()) + parsInt(1));
				}
			}		
		});
	}
	
	$('.teacher').click(function(){
		window.location.href = "teacher/teacherDetail.do?account=" + $(this).find('input').val();
	});
	
})
</script>
<script type="text/juicer" id="teacherList">
	{@each rows as teacher}
	 <div class="form-group clearfix teacher">
		<input type="hidden" value="${teacher.account}"/>
		<img src="${teacher.Reserve1}" alt="..."  class="img-circle float-left" height="80" width="80">
		<div class="info float-left">
			<h4 class="name">${teacher.Reserve5}</h4>
		     <span class="super super1">
             	{@if teacher.Reserve6 == 0}
 					普通
				{@else}
 					 专家
                {@/if}
			 </span>
		     <span class="super super2">${teacher.Reserve4}</span>
		 </div>
	</div>
	{@/each}
</script>
</html>


