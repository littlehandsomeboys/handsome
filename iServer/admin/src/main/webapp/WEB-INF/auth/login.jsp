<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<head>
<base href="<%=basePath%>">

<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="js/jquery-2.1.4.min.js"></script>
<!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->
</head>
<body>
	<script>
  $(function() {
    $('form').on('submit', function(e) {
      $('.loading').show();
      e.preventDefault();
      var data = $(this).serializeArray();
      $.ajax({
        url: '<%=path%>/auth/api/login.do',
        method: 'POST',
        data: data
      }).success(function(data) {
    	  location.href = "<%=path%>/";
      }).failure(function() {
        alert('登录失败!');
      }).always(function() {
        $('.loading').hide();
      });

      return false;
    });

  });
</script>

	<style>
label, input, button {
	display: block;
	margin: 5px;
}

button {
	padding: 10px 20px;
}
</style>
	<form>
		<p>用户登录</p>

		<p class="loading" style="display: none">loading...</p>

		<label for="username">用户名</label> <input type="text"
			name="username" id="username"> <label for="password">密码</label>
		<input type="password" name="password" id="password"> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit">提交</button>

		<p>
			<a href="<%=path%>/auth/signup.do">新用户注册</a>
		</p>
	</form>
</body>
</html>


