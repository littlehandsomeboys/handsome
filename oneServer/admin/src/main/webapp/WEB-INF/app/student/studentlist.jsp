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
    		<div align="center">
    		<!-- <div> -->
	    		<img height="180" src="/admin/static/image/topic.png"/>
	    		<!-- <img style="width:100%; height:100%; " src="/admin/static/image/flower.png"/> -->
    		</div>
    	</div>
    	<div id="studentlist" v-cloak>
			<div style="text-align:center" >
		        <select class="list-group-item" style="width:100%;" v-model="condition.classId" >
		        	<option selected="selected" value="0">全部校区</option>
		        	<option v-for="item in classSelect" :value="item.key" v-text="item.value"/>
		        </select>
			</div>
			<div>
				<a stype="margin-left:30px;">
					<b style="float:left; width: 32%; color:black;font-weight:normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;排名</b>
					<b style="float:left; width: 25%; color:black;font-weight:normal">姓名</b>
					<b style="float:left; width: 25%; color:black;font-weight:normal" >财富</b>
					<b style="color:black;font-weight:normal">级别</b>
				</a>
			</div>
			<div class="list-group">
				<div v-for="(item,index) in items" href="#" class="list-group-item">
				<div v-on:click="showTab(item)" style="min-height:68.59px;">
					<div>
						<!-- 排名  -->
						<div v-if="index=='0'" style="float:left; height:68.59px; width: 14%;">
						    <img style="height:68.59px;" src="/admin/static/image/1.png"/>
						</div>
						<div v-if="index=='1'" style="float:left; height:68.59px; width: 14%;">
						    <img style="height:68.59px;" src="/admin/static/image/2.png"/>
						</div>
						<div v-if="index=='2'" style="float:left; height:68.59px; width: 14%;">
						    <img style="height:68.59px;" src="/admin/static/image/3.png"/>
						</div>
						<div v-if="index!='0' & index!='1' & index!='2'" style="float:left;height:68.59px; width: 14%;">
							<b v-text="item.rowNo" style="font-size:20px;margin-top:15px;margin-left:20px;float:left;"></b>
						</div>
						<!-- 名字  -->
						<div style="float:left; height:29.59px; width: 39%; margin-top:13px;">
							<div style="margin-left:30px;">
								<h4 style="text-align:left;font-size:25px;" class="list-group-item-heading" v-text="item.englishName"></h4>
								<h4 style="text-align:left;font-size:15px;" class="list-group-item-heading" v-text="item.name"></h4>
							</div>
						</div>
						<!-- 积分 -->
						<div style="float:left;height:68.59px;width: 28%;font-size:15px;color:brown;">
							<p style="margin-left:16px;font-size:15px;color:brown;" class="list-group-item-text" v-text="item.point"></p>
						</div>
						<!-- 称号 -->
						<div v-if="item.topNo=='1'" style="height:68.59px;">
							<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;{{item.titleName}}</p>
							<img height="24" src="/admin/static/image/1.gif">
						</div>
						<div v-if="item.topNo=='2'" style="height:68.59px;">
							<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;{{item.titleName}}</p>
							<img height="24" src="/admin/static/image/2.gif">
						</div>
						<div v-if="item.topNo=='3'" style="height:68.59px;">
							<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;{{item.titleName}}</p>
							<img height="24" src="/admin/static/image/4.gif">
						</div>
						<div v-if="item.topNo==null" style="height:68.59px;">
							<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;{{item.titleName}}</p>
							<!-- <img alt="少尉" height="24" src="/admin/static/image/5.gif"> -->
						</div>
					</div>
					<div v-show="temp.show==item.id" v-model="temp.show" v-value="item.id">
					<div>
						<p>{{item.className}}|{{item.campName}}</p>
						<p><strong>成就&nbsp;&nbsp;</strong>{{item.note}}</p>
					</div>
				</div>
				</div>
			</div>
		</div>
    </body>
    <script type="text/javascript">
   
    </script>
</html>