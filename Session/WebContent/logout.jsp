<%@ page import="java.util.Enumeration" %>
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
			session.removeAttribute(sName);
	}
	%>
	
	<a href="sessiontest.jsp">sessionTest</a>

</body>
</html>