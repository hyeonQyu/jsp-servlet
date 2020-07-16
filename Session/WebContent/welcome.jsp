<%@page import="java.util.Enumeration"%>
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
	Enumeration<String> enume = session.getAttributeNames();
	while(enume.hasMoreElements()){
		String sName = enume.nextElement();
		String sValue = session.getAttribute(sName).toString();
		
		if(sValue.equals("abcde"))
			out.print("안녕하세요 " + sValue + "님<br/>");
	}
	%>
	
	<a href="logout.jsp">로그아웃</a>

</body>
</html>