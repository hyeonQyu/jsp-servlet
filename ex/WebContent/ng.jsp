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
	String str = request.getParameter("age");
	int age = Integer.parseInt(str);
	%>
	
	<%= age %>세입니다. 미성년자입니다.
	
	<a href="requestex.html">처음으로 이동</a>

</body>
</html>