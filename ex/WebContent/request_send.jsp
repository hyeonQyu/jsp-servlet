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
	
	if(age >= 20){
		response.sendRedirect("pass.jsp?age=" + age);
	}
	else{
		response.sendRedirect("ng.jsp?age=" + age);
	}
	
	out.println("나이 : " + age);
	%>

</body>
</html>