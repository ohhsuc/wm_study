<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职位详情</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH }/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-3.2.1.min.js"></script>
<script src="${APP_PATH }/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>招聘名称</th>
				<th>招聘要求</th>
				<th>发布公司</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${jobdetail.jobId }</td>
				<td>${jobdetail.jobName }</td>
				<td>${jobdetail.jobBewrite }</td>
				<td>${jobdetail.user.username }</td>
			</tr>
		</tbody>
	</table>
	<shiro:hasRole name="can">
		<button>提交申请</button>
	</shiro:hasRole>
<script>
	$("button").click(function(){
		$.ajax({
			url:'${APP_PATH }/exec/subapp/${jobdetail.jobId }',
			type:'get',
			success:function(result){
				alert(result.msg);
			}
		});
	});
</script>
</body>
</html>