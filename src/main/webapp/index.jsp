<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH }/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-3.2.1.min.js"></script>
<script src="${APP_PATH }/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>首页</h1>
	
	<shiro:guest>
		<h3><a href="${APP_PATH }/login">登陆</a></h3>
	</shiro:guest>
	
	<shiro:user>
		欢迎用户：<h4><shiro:principal /></h4>
		<h4><a href="logout">退出</a></h4>
	</shiro:user>
	
	<shiro:hasRole name="com">  
    	<h4>拥有角色com</h4><br/>
    	<h4><a href="${APP_PATH }/com/index">点击进入公司主页</a></h4>
	</shiro:hasRole>
	
	<shiro:hasRole name="can">  
    	<h4>拥有角色can</h4><br/>
    	<h4><a href="${APP_PATH }/can/index">点击进入个人主页</a></h4>
	</shiro:hasRole>
	
	<div class="col-md-12" style="width:500px;">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>招聘名称</th>
					<th>招聘要求</th>
					<th>发布公司</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="aljb">
	
			</tbody>
		</table>
	</div>
	<script>
		$(function(){
			$.ajax({
				url:"${APP_PATH}/AllJob",
				type:"get",
				success:function(result){
					console.table(result);
					var alljob = result.extend.allJob;
 					$.each(alljob,function(index,item){
						var jobid = $("<td></td>").append(item.jobId);
						var jobname = $("<td></td>").append(item.jobName);
						var jobbewrite = $("<td></td>").append(item.jobBewrite);
						var userid = $("<td></td>").append(item.user.username);
						var clkdtl = $("<a>点击查看</a>").attr("href","${APP_PATH}/JobDetail/"+item.jobId);
						$("<tr></tr>").append(jobid).append(jobname).append(jobbewrite).append(userid).append(clkdtl).appendTo("#aljb");
					}); 
				}
			});
		});
	</script>
</body>
</html>