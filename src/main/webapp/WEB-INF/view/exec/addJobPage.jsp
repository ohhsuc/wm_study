<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本公司添加职位</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH }/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-3.2.1.min.js"></script>
<script src="${APP_PATH }/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>本公司添加职位</h1>

		职位名称：<input type="text" id="jobname" name="jobName"/>
		职位详情：<textarea id="jobbewrite" name="jobBewrite" rows="1" cols="1"></textarea>
		<button>提交</button>

	<script>
		$("button").click(function(){
			$.ajax({
				url:"${APP_PATH }/exec/addJob",
				type:'post',
				data:{
					jobName:$("#jobname").val(),
					jobBewrite:$("#jobbewrite").val(),
				},
				success:function(result){
					alert("添加成功，影响行数："+result.extend.addComJob+"行");
				}
			});
		});
	</script>
</body>
</html>