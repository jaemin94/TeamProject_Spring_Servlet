<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>JOIN</h1>

<form name="joinform" action="${pageContext.request.contextPath }/join" method="post" onsubmit="return false">
	ID: <input name="username"><br/>
	PW: <input name="password" type="password"><br/>
	<button onclick="isValid()">JOIN</button>
</form>


<script>
	const isValid = ()=>{
		const form = document.joinform;
		if(form.username.value.trim()=="null")
			{
				alert("USERNAME 을 입력하세요!");
				return;
			}
		if(form.password.value.trim()=="null")
		{
			alert("PASSWORD 을 입력하세요!");
			return;
		}
		form.submit();
	}
</script>


</body>
</html>