<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta name="viewport"
			content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" /> 
        <script data-main="/admin/app/main.js" src="/admin/static/js/require.min.js"></script>
        <script type="text/javascript" >
        	require(["student/studentlist"]);
        </script>
    </head>
    <body>
    	<div id="studentlist">
			<div>
		        <input id="classId" v-model="condition.classId" placeholder="输入">
		        <br/>
		        <span  v-text="condition.classId" ></span>
			</div>
			<input id="jqt" type="button" value="input button" v-on:click="showData()"></input>
			
			<div class="list-group">
				<a v-for="item in items" href="#" class="list-group-item">
					<h4 class="list-group-item-heading" v-text="item.name"></h4>
					<p class="list-group-item-text" v-text="item.point"></p>
				</a>
			</div>
		</div>
    </body>
    <script type="text/javascript">
   
    </script>
</html>