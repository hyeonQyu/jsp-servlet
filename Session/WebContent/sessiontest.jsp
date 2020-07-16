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
	int i = 0;
	while(enume.hasMoreElements()){
		i++;
		
		String sName = enume.nextElement();
		String sValue = session.getAttribute(sName).toString();
		
		out.print(sName + "    " + sValue + "<br/>");
	}
	
	if(i == 0)
		out.print("해당 세션이 삭제 되었습니다.");
	%>

</body>
</html>