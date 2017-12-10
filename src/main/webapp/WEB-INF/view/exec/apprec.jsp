<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请列表</title>
</head>
<body>
	<h1>您申请过的职位：</h1>
	<table>
	<c:forEach items="${myapp }" var="app">
		<tr>
			<td>${app.appId }</td>
			<td><fmt:formatDate value="${app.appDate }" pattern="yyyy-MM-dd"/></td>
			<td>${app.job.jobName }</td>
 			<td>${app.job.jobBewrite }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>