<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司主页</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH }/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-3.2.1.min.js"></script>
<script src="${APP_PATH }/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1><a href="${APP_PATH }/exec/addJobPage">发布职位</a></h1><br/>
	<h1><a href="${APP_PATH }/exec/applist">查看申请自己公司的人</a></h1><br/>
	<h2>已发布的职位：</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>#</td>
				<td>职位名称</td>
				<td>职位详情</td>
				<td>发布人</td>
				<td>修改</td>
				<td>删除</td>
			</tr>
		</thead>
		<tbody id="aljb">

		</tbody>
	</table>
		<script>
		$(function(){
			$.ajax({
				url:"${APP_PATH}/exec/comJob",
				type:"get",
				success:function(result){
					console.table(result);
					var alljob = result.extend.comJob;
 					$.each(alljob,function(index,item){
						var jobid = $("<td></td>").append(item.jobId);
						var jobname = $("<td></td>").append('<input type="text" value="'+item.jobName+'" />');
						var jobbewrite = $("<td></td>").append('<input type="text" value="'+item.jobBewrite+'" />');
						var userid = $("<td></td>").append(item.user.username);
						var clkdtl = $("<button>点击修改</button>").attr("id","clkdtl");
						var clkdel = $("<button>删除</button>").attr("id","clkdel");
						$("<tr></tr>").append(jobid).append(jobname).append(jobbewrite).append(userid).append(clkdtl).append(clkdel).appendTo("#aljb");
					}); 
				}
			});
		});
		/* 修改 */
		$(document).on("click","#clkdtl",function(){
			var nbtn = this;
 			$.ajax({
				url:'${APP_PATH}/exec/comJobUpdate',
				type:'post',
				data:{
					jobId:$($(nbtn).parent().children().get(0)).html(),
					jobName:$($(nbtn).parent("tr").find("input").get(0)).val(),
					jobBewrite:$($(nbtn).parent("tr").find("input").get(1)).val(),
				},
				success:function(result){
					alert(result.msg);
				}
			});
		});
		/* 删除 */
		$(document).on("click","#clkdel",function(){
			var nbtn = this;
 			$.ajax({
				url:'${APP_PATH}/exec/delJob',
				type:'post',
				data:{
					id:$($(nbtn).parent().children().get(0)).html(),
				},
				success:function(result){
					alert(result.msg);
				}
			});
		});
	</script>
</body>
</html>