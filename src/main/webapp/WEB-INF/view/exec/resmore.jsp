<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>简历详情</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH }/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-3.2.1.min.js"></script>
<script src="${APP_PATH }/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>简历内容</h1>
	<table>
		<thead>
			<tr>
				<td>#</td>
				<td>gender</td>
				<td>phone</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${Resume.resId }</td>
				<td><input type="text" id="resgender" name="resGender" value="${Resume.resGender }"></td>
				<td><input type="text" id="resphone" name="resPhone" value="${Resume.resPhone }"></td>
			</tr>
		</tbody>
	</table>
		<button>修改</button>
	<script>
		$("button").click(function(){
			$.ajax({
				url:"${APP_PATH }/exec/resupdate",
				type:'post',
				data:{
					resGender:$("#resgender").val(),
					resPhone:$("#resphone").val(),
				},
				success:function(result){
					console.table(result);
					alert(result.msg);
				}
			});
		});
	</script>
</body>
</html>