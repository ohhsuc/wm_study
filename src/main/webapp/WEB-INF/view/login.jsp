<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h1>登陆</h1>

		<form action="${APP_PATH }/login" method="post">
		用户名：<input type="text" name="username" /><br />
		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /><br />
		<button type="submit">提交</button>
		</form>
	<script>
/* 		$("button").click(function(){
			$.ajax({
				type:'post',
				url:'${APP_PATH}/login',
				data:{
					type:$("select").find("option:selected").val(),
					name:$("#name").val(),
					pass:$("#pass").val(),
				},
				success:function(result){
					if(result.code == 100){
						alert("登陆成功");
					}else{
						alert("登录失败");
					}
				}
			});
		}); */
	</script>
</body>
</html>