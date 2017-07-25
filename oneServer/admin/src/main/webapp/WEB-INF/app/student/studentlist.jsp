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
        
        <style type="text/css">
        </style>
        
    </head>
    <body>
    	<div>
    		<div style="display:inline;width:60%;float:left;">
    			<img style="margin-left:20px;" height="100" src="/admin/static/image/fls_small_logo.png"/>
    		</div>
    		<div style="display:inline;">
	    		<img style="margin-top:30px;" height="70" src="/admin/static/image/list.png"/>
    		</div>
    	</div>
    	<%-- <div class="center-block" style="text-align:center">${schoolName}</div>
    	<div class="center-block" style="text-align:center">富豪榜</div> --%>
    	<div id="studentlist">
			<div style="text-align:center" >
		        <!-- <input id="classId" v-model="condition.classId" placeholder="输入"> -->
		        <select class="list-group-item" style="width:100%;" v-model="condition.classId" >
		        	<option selected="selected" value="0">全部校区</option>
		        	<option v-for="item in classSelect" :value="item.key" v-text="item.value"/>
		        </select>
			</div>
			<div class="list-group">
				<a class="list-group-item">
					<b style="float:left; width: 20%;">排名</b>
					<b style="float:left; width: 40%;"> 姓名</b>
					<b class="list-group-item-text">资产</b>
				</a>
			</div>
			<div class="list-group">
				<div v-for="(item,index) in items" href="#" class="list-group-item">
				<div v-on:click="showTab(item)" style="min-height:68.59px;">
					<div>
						<b v-if="index=='0'" text="" style="float:left; height:68.59px; width: 20%;background: url(http://js.18183.com/pc/db/wzry/images/rank_1.png) no-repeat;"></b>
						<b v-if="index=='1'" text="" style="float:left; height:68.59px; width: 20%;background: url(http://js.18183.com/pc/db/wzry/images/rank_2.png) no-repeat;"></b>
						<b v-if="index=='2'" text="" style="float:left; height:68.59px; width: 20%;background: url(http://js.18183.com/pc/db/wzry/images/rank_3.png) no-repeat;"></b>
						<b v-if="index!='0' & index!='1' & index!='2'" v-text="item.rowNo" style="font-size:20px;margin-top:15px;text-align:center;float:left;height:29.59px; width: 20%;"></b>
						
						<div style="float:left; height:29.59px; width: 40%; margin-top:13px;">
							<h4 style="font-size:25px;" class="list-group-item-heading" v-text="item.name"></h4>
							<h4 style="font-size:15px;" class="list-group-item-heading" v-text="item.englishName"></h4>
						</div>
						
						<p style="height:68.59px;font-size:15px;color:brown;" class="list-group-item-text" v-text="item.point"></p>
					</div>
					<div v-show="temp.show==item.id" v-model="temp.show" v-value="item.id">
						<strong>成就：</strong><p v-text="item.note"></p>
					</div>
				</div>
				</div>
			</div>
		</div>
    </body>
    <script type="text/javascript">
   
    </script>
</html>