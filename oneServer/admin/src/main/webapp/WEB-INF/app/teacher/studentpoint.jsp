<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
    <title>${schoolName}</title>
    	<meta name="viewport"
			content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" /> 
        <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.css"></link>
        <style type="text/css">
        
        </style>
    </head>
    <body>
    	<div id="honorroll">
			<div style="text-align:center" >
		        <select id="classSelect" class="list-group-item" style="width:100%;" >
		        	<option selected="selected" value="0">请选择</option>
		        	<c:forEach items="${classList}" var="item">
		        		<option value="${item.key}">${item.value}</option>
		        	</c:forEach>
		        </select>
			</div>
			<table style="width:100%;border-collapse:separate;border-spacing:0px 20px;">
				<thead>
					<tr>
						<th>学号</th>
						<th>中文名</th>
						<th>英文名</th>
						<th>操作</th>
					</tr>
				</thead>
			
				<tbody id="studentclasslist" class="list-group">
				
				</tbody>
			</table>
		</div>
		<div id="delete" class="white_content">
		      <div class="close"><a href="javascript:void(0)" onclick="hide('delete')">关闭</a></div>
		      <div class="con"> 
		      <div id="lastrecords">
		      </div> 
		      </div>
		</div>
		<div id="add" class="white_content">
		      <div class="close"><a href="javascript:void(0)" onclick="hide('add')">关闭</a></div>
		      <div class="con"> 
		      <div id="addrecord">
		      </div> 
		      </div>
		      <input id="submit" type="button" onclick="submit()" value="提交"></input>
		</div>
		<div id="fade" class="black_overlay"></div>
    </body>
    <script type="text/javascript">
   		function showTab(event) {
   			var hidden = $(event).find("#exTab").attr("hidden");
   			if ("hidden" == hidden) {
   				$(event).find("#exTab").removeAttr("hidden"); 
   			}
   			else {
   				$(event).find("#exTab").attr("hidden","hidden");
   			}
   		}
   		
   		$('#classSelect').change(function () {
   			var condition={
   				classId : $('#classSelect').val()
   			};
   		 	$.ajax({
				type : 'GET',
				dataType : "html",
				data : condition,
				url : '/mrfu/app/teacher/studentlist.do',
				success : function(data) {
					$('#studentclasslist').html(data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$('#studentclasslist').html(data);
					alert(errorThrown);
				}
			});
   		})
   		
   		function show(tag,studentId){
   			var condition={
   					studentId : studentId
   	   			};
   			if ("add" == tag) {
   				$.ajax({
					type : 'GET',
					dataType : "html",
					data : condition,
					url : '/mrfu/app/teacher/addrecord.do',
					success : function(data) {
						$('#addrecord').html(data);
						var light=document.getElementById(tag);
						 var fade=document.getElementById('fade');
						 light.style.display='block';
						 fade.style.display='block';
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert(errorThrown);
					}
				});
			}
   			else {
	   			$.ajax({
					type : 'GET',
					dataType : "html",
					data : condition,
					url : '/mrfu/app/teacher/getlastrecords.do',
					success : function(data) {
						$('#lastrecords').html(data);
						var light=document.getElementById(tag);
						 var fade=document.getElementById('fade');
						 light.style.display='block';
						 fade.style.display='block';
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert(errorThrown);
					}
				});
   			}
		 }
   		
		function hide(tag){
		 var light=document.getElementById(tag);
		 var fade=document.getElementById('fade');
		 light.style.display='none';
		 fade.style.display='none';
		}
		
		function submit() {
   			var condition={
   	   			cardId : $('#cardSelect').val(),
   	   			num: $('#numIn').val(),
   	   			studentId: $('#studentIdIn').val(),
   	   			remark:$('#remarkIn').val()
   	   		};
   			if (null == condition.num || '' == condition.num || 'undefine' == condition.num) {
   				alert("请填写数量");
   				return;
   			}
   			$.ajax({
				type : 'POST',
				data : condition,
				url : '/mrfu/app/teacher/submit.do',
				success : function(data) {
					if ("ok" == data) {
						alert("成功了");
					}
					else {
						alert("失败了");
					}
					
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
				}
			});
   		};
   		
   		function deleteRecords(id,num,name) {
   			if(!confirm("确实要删除'"+num+"'个'"+name+"'卡吗?")){
   				return;
   			}
   			var condition={
   					id : id
   	   		};
   			$.ajax({
				type : 'POST',
				data : condition,
				url : '/mrfu/app/teacher/deleteStuCardRel.do',
				success : function(data) {
					if ("ok" == data) {
						alert("成功了");
					}
					else {
						alert("失败了");
					}
					
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
				}
			});
   		};
    </script>
    <style>
*{
 margin:0;
 padding:0
}
html, body {
 height: 100%;
 width: 100%;
 font-size:12px
}
.white_content {
 display: none;
 position: absolute;
 top: 5%;
 left: 5%;
 width: 90%;
 /* padding: 6px 16px; */
 border: 12px solid #D6E9F1;
 background-color: white;
 z-index:1002;
 overflow: auto;
}
.black_overlay {
 display: none;
 position: absolute;
 top: 0%;
 left: 0%;
 width: 100%;
 height: 100%;
 background-color:#f5f5f5;
 z-index:1001;
 -moz-opacity: 0.8;
 opacity:.80;
 filter: alpha(opacity=80);
}
.close {
 float:right;
 clear:both;
 width:100%;
 text-align:right;
 margin:0 0 6px 0
}
.close a {
 color:#333;
 text-decoration:none;
 font-size:14px;
 font-weight:700
}
.con {
 text-indent:1.5pc;
 line-height:21px
}
</style>
</html>