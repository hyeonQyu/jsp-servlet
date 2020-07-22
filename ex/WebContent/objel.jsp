<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="objelOk.jsp" method="get">
		아이디 : <input type="text" name="id" size="10"><br/>
		비밀번호 : <input type="password" name="pw" size="10"><br/>
		<input type="submit" value="로그인">
	</form>
	
	<%
		application.setAttribute("application_name", "application_value");
		session.setAttribute("session_name", "session_value");
		pageContext.setAttribute("pageContext_name", "pageContext_value");
		request.setAttribute("request_name", "request_value");
	%>

</body>
</html>