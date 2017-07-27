<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>${schoolName}</title>
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
    		<!-- <div style="display:inline;width:60%;float:left;">
    			<img style="margin-left:20px;" height="100" src="/admin/static/image/fls_small_logo.png"/>
    		</div>
    		<div style="display:inline;">
	    		<img style="margin-top:20px;" height="80" src="/admin/static/image/list.png"/>
    		</div> -->
    		
    		<div align="center">
	    		<img height="180" src="/admin/static/image/topic.png"/>
    		</div>
    	</div>
    	<%-- <div class="center-block" style="text-align:center">${schoolName}</div>
    	<div class="center-block" style="text-align:center">富豪榜</div> --%>
    	<div id="studentlist" v-cloak>
			<div style="text-align:center" >
		        <!-- <input id="classId" v-model="condition.classId" placeholder="输入"> -->
		        <select class="list-group-item" style="width:100%;" v-model="condition.classId" >
		        	<option selected="selected" value="0">全部校区</option>
		        	<option v-for="item in classSelect" :value="item.key" v-text="item.value"/>
		        </select>
			</div>
			<div>
				<a class="list-group-item">
					<b style="float:left; width: 29%;">排名</b>
					<b style="float:left; width: 28%;">姓名</b>
					<b style="float:left; width: 28%;" >财富</b>
					<b>级别</b>
				</a>
			</div>
			<div class="list-group">
				<div v-for="(item,index) in items" href="#" class="list-group-item">
				<div v-on:click="showTab(item)" style="min-height:68.59px;">
					<div>
						<div v-if="index=='0'" style="float:left; height:68.59px; width: 14%;">
						    <img style="height:68.59px;" src="http://js.18183.com/pc/db/wzry/images/rank_1.png"/>
						</div>
						<div v-if="index=='1'" style="float:left; height:68.59px; width: 14%;">
						    <img style="height:68.59px;" src="http://js.18183.com/pc/db/wzry/images/rank_2.png"/>
						</div>
						<div v-if="index=='2'" style="float:left; height:68.59px; width: 14%;">
						    <img style="height:68.59px;" src="http://js.18183.com/pc/db/wzry/images/rank_3.png"/>
						</div>
						<!-- <b v-if="index=='0'" text="" style="float:left; height:68.59px; width: 14%;background: url(http://js.18183.com/pc/db/wzry/images/rank_1.png) no-repeat;"></b>
						<b v-if="index=='1'" text="" style="float:left; height:68.59px; width: 14%;background: url(http://js.18183.com/pc/db/wzry/images/rank_2.png) no-repeat;"></b>
						<b v-if="index=='2'" text="" style="float:left; height:68.59px; width: 14%;background: url(http://js.18183.com/pc/db/wzry/images/rank_3.png) no-repeat;"></b> -->
						<div v-if="index!='0' & index!='1' & index!='2'" style="float:left;height:68.59px; width: 14%;">
							<b v-text="item.rowNo" style="font-size:20px;margin-top:15px;margin-left:12px;float:left;"></b>
						</div>
						
						<div style="float:left; height:29.59px; width: 39%; margin-top:13px;">
						<div style="margin-left:30px;">
							<h4 style="text-align:left;font-size:25px;" class="list-group-item-heading" v-text="item.englishName"></h4>
							<h4 style="text-align:left;font-size:15px;" class="list-group-item-heading" v-text="item.name"></h4>
						</div>
						</div>
						
						<div style="float:left;height:68.59px;width: 28%;font-size:15px;color:brown;">
							<p style="margin-left:16px;font-size:15px;color:brown;" class="list-group-item-text" v-text="item.point"></p>
						</div>
					
						<div v-if="item.topNo=='1'" style="height:68.59px;">
							<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;少将</p>
							<img alt="少将" height="24" src="/admin/static/image/1.gif">
						</div>
						<div v-if="item.topNo=='2'" style="height:68.59px;">
							<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;少校</p>
							<img alt="少校" height="24" src="/admin/static/image/2.gif">
						</div>
						<div v-if="item.topNo=='3'" style="height:68.59px;">
							<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;少尉</p>
							<img alt="少尉" height="24" src="/admin/static/image/4.gif">
						</div>
						<div v-if="item.topNo==null" style="height:68.59px;">
							<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;士兵</p>
							<!-- <img alt="少尉" height="24" src="/admin/static/image/5.gif"> -->
						</div>
					</div>
					<div v-show="temp.show==item.id" v-model="temp.show" v-value="item.id">
					<div>
						<p><strong>成就&nbsp;&nbsp;</strong>{{item.note}}</p>
						<p><strong>班级&nbsp;&nbsp;</strong>{{item.className}}</p>
					</div>
				</div>
				</div>
			</div>
		</div>
    </body>
    <script type="text/javascript">
   
    </script>
</html>