<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

				<c:forEach items="${studentList}" var="item">
					<tr>
							<th>${item.code}</th>
							<th>${item.name}</th>
							<th>${item.englishName}</th>
							<th onclick="show('delete','${item.id}')">删除</th>
							<th onclick="show('add','${item.id}')">&nbsp;&nbsp;&nbsp;&nbsp;添加</th>
					</tr>
					
				</c:forEach>
