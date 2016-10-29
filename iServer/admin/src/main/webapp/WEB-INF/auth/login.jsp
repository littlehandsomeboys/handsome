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
<meta charset="UTF-8">
<title>Admin</title>
<head>
<base href="<%=basePath%>">

<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">
<script src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="themes/icon.css" />
<link rel="stylesheet" type="text/css" href="themes/gray/easyui.css" />
<!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->
</head>
<body>
	<script>
  $(function() {
    $('form').on('submit', function(e) {
		$('.tip_account').hide();
		$('.tip_pwd').hide();
		$('.tip_account_pwd').hide();
		$('.tip_error').hide();
      $('.tip_loading').show();
      e.preventDefault();
      var data = $(this).serializeArray();
      $.ajax({
        url: '<%=path%>/auth/api/login.do',
        method: 'POST',
        data: data
      }).success(function(data) {
    	  //数据转换
    	  if (typeof data === 'object') {
    		  data = data;
			} else {
				data = eval("(" + data + ")")
			}
    	  	//登录提示
    	  	if (data.code == 0) {
	    	  	location.href = "<%=path%>/main.do";
					} else if (data.code == 1) {
						$('.tip_loading').hide();
						$('.tip_account_pwd').show();
					} else if (data.code == 2) {
						$('.tip_loading').hide();
						$('.tip_account').show();
					} else if (data.code == 3) {
						$('.tip_loading').hide();
						$('.tip_pwd').show();
					} else {
						$('.tip_loading').hide();
						$('.tip_error').show();
					}
				}).failure(function() {
					$('.tip_loading').hide();
					$('.tip_error').show();
				});
				return false;
			});

		});
	</script>

	<style type="text/css">
label, input, button {
	display: block;
	margin: 10px;
}

button {
	padding: 5px 20px;
}

* {
	margin: 0;
	padding: 0;
	/* background-color: #EAEAEA; */
}

.background-login {
	background-image: url(pic/background.jpg);
	background-repeat: no-repeat;
	background-size: 1200px;
}

.title-login {
	width: 1000px;
	height: 100px;
	/* background-color: #1E90FF; */
}

.south-login {
	color: #6c6c6c;
	font-family: Microsoft YaHei;
	font-size: 5px;
}

.center-in-center {
	position: absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	-moz-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	-o-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}
</style>
	<p style="margin:10px 50px">
		<a style="font-family:KaiTi;font-size:20px">教育信息管理平台</a>
		<a href="#" id="singup" style="float:right;padding-right:10px;font-size:5px">暂未开放注册</a>
	</p>
	<div class="background-login" style="width:1500px;height:600px;margin:10px 50px 10px 50px" >
		<form class="window" style="margin:220px 820px;opacity:0.8">
			<p style="font-size:200%;font-family:SimHei;">用户登录</p>

			<p class="tip_loading" style="display:none;font-family:KaiTi;color:green">提交中...</p>
			<p class="tip_account" style="display:none;font-family:KaiTi;color:red">请填写用户名</p>
			<p class="tip_pwd" style="display:none;font-family:KaiTi;color:red">请填写密码</p>
			<p class="tip_account_pwd" style="display:none;font-family:KaiTi;color:red">用户名或密码错误</p>
			<p class="tip_error" style="display:none;font-family:KaiTi;color:red">登录失败</p>

			<label for="username">用户名:</label>
			<input type="text" name="username" id="username">
			<label for="password">密码:</label>
			<input type="password" name="password" id="password">
				<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
			<button type="submit">提交</button>

			<%-- <p>
				<a href="<%=path%>/auth/signup.do">新用户注册</a>
			</p> --%>
		</form>
	</div>
	<div region="south" split="true" style="height:30px;margin:10px 50px">
	<p>
    	<a href="http://www.baidu.com" class="south-login">百度</a>
    	<b class="south-login">|</b>
    	<a href="http://www.aliyun.com" class="south-login">阿里云</a>
    	<em class="footer" style="font-size:5px">© 版权所有，翻版必究</em>
    </p>
</body>
</html>


