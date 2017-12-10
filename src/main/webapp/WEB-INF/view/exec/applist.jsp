<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请本公司的人</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH }/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-3.2.1.min.js"></script>
<script src="${APP_PATH }/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>申请本公司的人</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>#</td>
				<td>申请时间</td>
				<td>申请职位</td>
				<td>申请人</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${comapp }" var="app">
			<tr>
				<td>${app.appId }</td>
				<td><fmt:formatDate value="${app.appDate }" pattern="yyyy-MM-dd"/></td>
				<td>${app.job.jobName }</td>
				<td>${app.user.username }</td>
				<td><a href="${APP_PATH }/exec/watres/${app.user.uid}">查看简历</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>