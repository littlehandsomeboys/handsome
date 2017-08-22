
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<div>
	<table style="width:100%;border-collapse:separate;border-spacing:0px 20px;">
		<thead>
			<tr>
				<th>卡名</th>
				<th>数目</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${lastrecords}" var="item">
					<tr>
						<th>${item.cardName}</th>
						<th>${item.num}</th>
						<th>${item.remark}</th>
						<th onclick="deleteRecords('${item.id}','${item.num}','${item.cardName}')">删除</th>
					</tr>
				</c:forEach>
		</tbody>
	</table>
</div>