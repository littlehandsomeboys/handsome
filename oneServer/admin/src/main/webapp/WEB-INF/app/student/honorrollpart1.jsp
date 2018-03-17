<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

				<c:forEach items="${studentList}" var="item" varStatus="status">
					<div href="#" class="list-group-item" onclick="javascript:showTab(this);">
						<div style="min-height:68.59px;">
						<!-- <div v-on:click="showTab(item)" style="min-height:68.59px;"> -->
							<div>
								<c:if test="${status.index == '0'}">
									<div style="float:left; height:68.59px; width: 14%;">
									    <img style="height:68.59px;" src="/mrfu/static/image/1.png"/>
									</div>
								</c:if>
								<c:if test="${status.index == '1'}">
									<div style="float:left; height:68.59px; width: 14%;">
									    <img style="height:68.59px;" src="/mrfu/static/image/2.png"/>
									</div>
								</c:if>
								<c:if test="${status.index == '2'}">
									<div style="float:left; height:68.59px; width: 14%;">
									    <img style="height:68.59px;" src="/mrfu/static/image/3.png"/>
									</div>
								</c:if>
								<c:if test="${status.index!='0' && status.index!='1' && status.index!='2'}">
									<div style="float:left;height:68.59px; width: 14%;">
										<b style="font-size:20px;margin-top:15px;margin-left:20px;float:left;">${item.rowNo}</b>
									</div>
								</c:if>
								<div style="float:left; height:29.59px; width: 39%; margin-top:13px;">
									<div style="margin-left:30px;">
										<h4 style="text-align:left;font-size:25px;" class="list-group-item-heading" >${item.englishName}</h4>
										<h4 style="text-align:left;font-size:15px;" class="list-group-item-heading" >${item.name}</h4>
									</div>
								</div>
								<div style="float:left;height:68.59px;width: 21%;font-size:15px;color:brown;">
									<p style="margin-left:16px;font-size:15px;color:brown;" class="list-group-item-text">${item.point}</p>
									<c:if test="${'1'==item.campId}">
										<img height="50" src="/mrfu/static/image/camp/lc_done.png">
									</c:if>
									<c:if test="${'2'==item.campId}">
										<img height="50" src="/mrfu/static/image/camp/fhc_done.png">
									</c:if>
									<c:if test="${'3'==item.campId}">
										<img height="50" src="/mrfu/static/image/camp/sc_done.png">
									</c:if>
									<c:if test="${'4'==item.campId}">
										<img height="50" src="/mrfu/static/image/camp/xlc_done.png">
									</c:if>
									<c:if test="${'5'==item.campId}">
										<img height="50" src="/mrfu/static/image/camp/lwc_done.png">
									</c:if>
									<c:if test="${'6'==item.campId}">
										<img height="50" src="/mrfu/static/image/camp/dyc_done.png">
									</c:if>
									<c:if test="${'7'==item.campId}">
										<img height="50" src="/mrfu/static/image/camp/rlc_done.png">
									</c:if>
									<c:if test="${'8'==item.campId}">
										<img height="50" src="/mrfu/static/image/camp/yrc_done.png">
									</c:if>
									<c:if test="${'9'==item.campId}">
										<img height="50" src="/mrfu/static/image/camp/zyc_done.png">
									</c:if>
								</div>
								<div style="height:68.59px;" align="center">
									<p style="font-size:15px;" >&nbsp;&nbsp;&nbsp;${item.titleName}</p>
									<c:if test="${item.titleId=='1'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/cq.png">
									</c:if>
									<c:if test="${item.titleId=='2'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/gmqs.png">
									</c:if>
									<c:if test="${item.titleId=='3'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/haqs.png">
									</c:if>
									<c:if test="${item.titleId=='4'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/hhsj.png">
									</c:if>
									<c:if test="${item.titleId=='5'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/wwzj.png">
									</c:if>
									<c:if test="${item.titleId=='6'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/tqsj.png">
									</c:if>
									<c:if test="${item.titleId=='7'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/hjqs.png">
									</c:if>
									<c:if test="${item.titleId=='8'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/byqs.png">
									</c:if>
									<c:if test="${item.titleId=='9'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/qtqs.png">
									</c:if>
									<c:if test="${item.titleId=='10'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/bz.png">
									</c:if>
									<c:if test="${item.titleId=='11'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/bb.png">
									</c:if>
									<c:if test="${item.titleId=='12'}">
										<img style="margin-top:-5px;margin-left:5px;" height="40" src="/mrfu/static/image/topic/ys.png">
									</c:if>
								</div>
							</div>
							<div id="exTab" hidden="hidden">
								<table style="table-layout:fixed;width: 100%;">
									<tr> 
										<td style="width: 55%;" valign="top">
											<strong>荣耀</strong>
											<c:if test="${null!=item.note}">
												<p>${item.note}</p>
											</c:if>
										</td> 
										<td valign="top">
											<strong>来自</strong>
											<p>${item.className}</p>
											<c:if test="${item.campName != null}">
												<p>【${item.campName}】</p>
											</c:if>
										</td> 
									</tr>
								</table>
							</div>
						</div>
					</div>
				</c:forEach>