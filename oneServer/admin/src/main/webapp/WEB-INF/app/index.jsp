<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" /> 
        <script data-main="/mrfu/app/main.js" src="/mrfu/static/js/require.min.js"></script>
        <script type="text/javascript" >
        	require(["index"]);
        </script>
    </head>
    <body>
    	<div id="app">
			<div>
		        <input id="account" v-model="condition.account" placeholder="输入">
		        <br/>
		        <span  v-text="condition.account" ></span>
			</div>
			<input id="jqt" type="button" value="input button" v-on:click="showData()"></input>
			
			<div class="list-group">
				<a v-for="item in items" href="#" class="list-group-item">
					<h4 class="list-group-item-heading" v-text="item.account"></h4>
					<p class="list-group-item-text" v-text="item.email"></p>
				</a>
			</div>
		</div>
    </body>
    <script type="text/javascript">
   
    </script>
</html>