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
	    		<img height="150" src="/admin/static/image/topic.png"/>
	    		<!-- <img style="width:100%; height:100%; " src="/admin/static/image/flower.png"/> -->
    		</div>
    	</div>
    	<div id="studentlist" v-cloak>
			<div style="text-align:center" >
		        <select class="list-group-item" style="width:100%;" v-model="condition.classId" >
		        	<option selected="selected" value="0">全部班级</option>
		        	<option v-for="item in classSelect" :value="item.key" v-text="item.value"/>
		        </select>
			</div>
			<div>
				<a stype="margin-left:30px;">
					<b style="float:left; width: 32%; color:black;font-weight:normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;排名</b>
					<b style="float:left; width: 25%; color:black;font-weight:normal">姓名</b>
					<b style="float:left; width: 25%; color:black;font-weight:normal" >金币</b>
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
						<div style="float:left;height:68.59px;width: 21%;font-size:15px;color:brown;">
							<p style="margin-left:16px;font-size:15px;color:brown;" class="list-group-item-text" v-text="item.point"></p>
							<img v-if="'1'==item.campId" height="50" src="/admin/static/image/camp/lc_done.png">
							<img v-if="'2'==item.campId" height="50" src="/admin/static/image/camp/fhc_done.png">
							<img v-if="'3'==item.campId" height="50" src="/admin/static/image/camp/sc_done.png">
							<img v-if="'4'==item.campId" height="50" src="/admin/static/image/camp/xlc_done.png">
							<img v-if="'5'==item.campId" height="50" src="/admin/static/image/camp/lwc_done.png">
							<img v-if="'6'==item.campId" height="50" src="/admin/static/image/camp/dyc_done.png">
							<img v-if="'7'==item.campId" height="50" src="/admin/static/image/camp/rlc_done.png">
							<img v-if="'8'==item.campId" height="50" src="/admin/static/image/camp/yrc_done.png">
							<img v-if="'9'==item.campId" height="50" src="/admin/static/image/camp/zyc_done.png">
						</div>
						<!-- 称号 -->
						<div style="height:68.59px;" align="center">
							<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;{{item.titleName}}</p>
							<img v-if="item.titleId=='1'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/cq.png">
							<img v-if="item.titleId=='2'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/gmqs.png">
							<img v-if="item.titleId=='3'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/haqs.png">
							<img v-if="item.titleId=='4'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/hhsj.png">
							<img v-if="item.titleId=='5'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/wwzj.png">
							<img v-if="item.titleId=='6'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/tqsj.png">
							<img v-if="item.titleId=='7'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/hjqs.png">
							<img v-if="item.titleId=='8'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/byqs.png">
							<img v-if="item.titleId=='9'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/qtqs.png">
							<img v-if="item.titleId=='10'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/bz.png">
							<img v-if="item.titleId=='11'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/bb.png">
							<img v-if="item.titleId=='12'" style="margin-top:-5px;margin-left:5px;" height="40" src="/admin/static/image/topic/ys.png">
						</div>
					</div>
					<div v-show="temp.show==item.id" v-model="temp.show" v-value="item.id">
						<table style="table-layout:fixed;width: 100%;">
							<tr> 
								<td style="width: 55%;" valign="top">
									<strong>荣耀</strong>
									<p v-if="null!=item.note" v-html="item.note"></p>
								</td> 
								<td valign="top">
									<strong>来自</strong>
									<p v-text="item.className"></p>
									<p v-if="item.campName != null" v-text="'【'+item.campName+'】'"></p>
								</td> 
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
    </body>
    <script type="text/javascript">
   
    </script>
</html>