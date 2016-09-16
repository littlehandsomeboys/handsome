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
<title>Portal</title>
<head>
<base href="<%=basePath%>">

<title>产品查询</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="js/jquery.min.js"></script>
<script src="js/jquery.easyui.min.js"></script>

</head>
<body>
	<script>
  function searchProduct()
  {
      $.ajax({
          url: '<%=path%>/product/api/productlist.do',
				data : {productName:$("#productName").val()},
				type: "post",
				dataType: "json",
				contentType: "application/json; charset=utf-8",
				success : function(data) {
					alert(data);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){

					alert(errorThrown);

				}

			});
		}
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

	产品名称：
	<input type="text" name="productName" id="productName" />
	<input type="button" onclick="searchProduct()" value="Search">查询
	</input>
	<br>
	<table id="mytable" border="16" width="80%">
		<tr bgcolor="#00ffff">
			<td>id</td>
			<td>pname</td>
		</tr>
		<tbody id="mybody">
		</tbody>
	</table>
</body>


</html>


