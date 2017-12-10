<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>can的个人主页</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
</head>
<body align="center">
	<h1><a href="${APP_PATH }/exec/resmore">查看修改简历</a></h1><br/>
	<h1><a href="${APP_PATH }/exec/apprec">申请记录</a></h1>
</body>
</html>