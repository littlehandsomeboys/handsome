<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<div>
	<input id="studentIdIn" type="hidden" value="${studentId}"></input>
	<select id="cardSelect" class="list-group-item" style="width:100%;" >
		<c:forEach items="${cards}" var="item">
			<option value="${item.key}">${item.value}</option>
		</c:forEach>
	</select>
	获得卡数目：<input id="numIn" type="number"></input>
	<br/>
	备注：<input id="remarkIn" type="text"></input>
</div>