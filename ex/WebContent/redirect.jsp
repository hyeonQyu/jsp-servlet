<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setAttribute("id", "abcd");
	request.setAttribute("pw", "12345");
	
	// sendRedirect를 통해 HttpServletResponse 클래스에 request 객체를 그대로 전달하지 않음
	response.sendRedirect("RequestObj2");
%>

</body>
</html>