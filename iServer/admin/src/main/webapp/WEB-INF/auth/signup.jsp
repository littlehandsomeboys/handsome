<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<html>
<head>
<base href="<%=basePath%>">
<title>注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<script src="/auth/jquery-2.1.4.min.js"></script>
	<script>
    $(function() {

        $('form').on('submit', function(e) {

            e.preventDefault();

            if ($('#password').val() !== $('#repassword').val()) {
                alert('两次密码不一样');
                return;
            }

            var data = $(this).serializeArray();

            $.ajax({
                url: '<%=path%>/auth/api/signup.do',
                method: 'POST',
                data: data
            }).success(function(data) {
                if (data.code === 0) {
                    location.href = "<%=path%>/auth/login.do";
                } else {
                    alert(data.error);
                }
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
		<p>用户注册</p>

		<label for="username">用户名</label> <input type="text" name="username"
			id="username">
		<p>大小写字母和数字, 长度6-20</p>

		<label for="password">密码</label> <input type="password"
			name="password" id="password">
		<p>必须包含大小写字母和数字, 长度6-20</p>

		<label for="repassword">重复密码</label> <input type="password"
			name="repassword" id="repassword"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />

		<button type="submit">提交</button>
	</form>

</body>
</html>
