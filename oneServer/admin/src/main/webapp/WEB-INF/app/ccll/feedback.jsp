<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
    <title>小华为的信件评分</title>
    	<meta name="viewport"
			content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" /> 
        <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <!-- <script type="text/javascript" src="../../mrfu/static/js/bootstrap.min.js"></script> -->
        <script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.css"></link>
        
        <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  	<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  
        <style type="text/css">
        
        </style>
    </head>
    <body>
    	<div>
    		<div align="center">
    		<!-- <div> -->
	    		<img style="width:100%;" src="/mrfu/static/image/xhw.jpg"/>
	    		<!-- <img style="width:100%; height:100%; " src="/mrfu/static/image/flower.png"/> -->
    		</div>
    	</div>
    	<br/>
    	<div>
			<div >
				<front style="color:red">*</front>1、亲，请给本次作文打个分哦！
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio"  name="select1" value="0" />一个字，满分！└(^o^)┘</label> 
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio"  name="select1" value="1" />马马虎虎，你及格了！^_^</label>
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio"  name="select1" value="2" /> 负分滚粗！⊙﹏⊙</label> 
			</div>
			<br/>
			<div>
				<front style="color:red">*</front>2、有什么想说的（100字以内就行，多一点也没关系）：
				<br/>
				<textarea id="note" style="width:100%;" rows="5"></textarea>
			</div>
			
			<br/>
			<div align="center">
				<input id="opener" type="button" value="已经填好了，点我！点我！"></input>
			</div>
			
			<div id="dialog" title="404">
				<p>Can Not Find Object!</p>
			  	<p>哎呀呀，写程序的人出错了，找不到对象怎么办？</p>
			</div>
			
			<br/>
			<p style="color:#999;font:12px arial;text-align:center">(¯(∞)¯)</p>
			<p style="color:#999;font:12px arial;text-align:center">@2017.8 xhw 这么丑的页面谁做的？</p>
			<br/>
		</div>
    </body>
    <script type="text/javascript">
    
    $(function() {
        $( "#dialog" ).dialog({
          autoOpen: false,
          show: {
            effect: "blind",
            duration: 1000
          },
          hide: {
            effect: "explode",
            duration: 1000
          },
          modal: true,
          buttons: {
	            "看不懂什么鬼（点击继续）": function() {
	              $( this ).dialog( "close" );
	              submit('0');
	            }
          }
        });
     
        $( "#opener" ).click(function() {
        	if (valid()) {
          		$( "#dialog" ).dialog( "open" );
        	}
        });
      });
   		function submit(s2) {
   			
   			var s1=$('input:radio[name="select1"]:checked').val(),
   			n=$('#note').val();
   			var ccll={
   	   				"select1":s1,
   	   				"select2": s2,
   	   				"note":n
   	   			};
   			
   			$.ajax({
				type : 'POST',
				data : ccll,
				url : '/mrfu/xhw/submit.do',
				success : function(data) {
					if ('0'==s2) {
						alert("似乎是提交成功了~");
					} if ('1'==s2) {
						alert("似乎是提交成功了~");
					} if ('2'==s2) {
						alert("似乎是提交成功了~");
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
				}
			});
   		};
   		function valid() {
        	var s1=$('input:radio[name="select1"]:checked').val(),
   			n=$('#note').val();
        	if ("0" != s1 && "1" != s1 && "2" != s1) {
				alert("请先打分！");
				return false;
			}
			if (n == 'undefind' || n == null || n.replace(/(^\s*)|(\s*$)/g, "") == '') {
				alert("请先填写意见和建议！");
				return false;
			}
			return true;
   		}
    </script>
</html>