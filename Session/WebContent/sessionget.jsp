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
	Object obj1 = session.getAttribute("mySessionName");
	String mySessionName = (String)obj1;
	out.print(mySessionName + "<br/>");
	
	Object obj2 = session.getAttribute("myNum");
	Integer myNum = (Integer)obj2;
	out.print(myNum + "<br/>");
	
	out.print("===========<br/>");
	
	String sName, sValue;
	Enumeration<String> enumeration = session.getAttributeNames();
	while(enumeration.hasMoreElements()){
		sName = enumeration.nextElement().toString();
		sValue = session.getAttribute(sName).toString();
		out.print(sName + "    " + sValue + "<br/>");
	}
	out.print("==========<br/>");
	
	String sessionId = session.getId();
	out.print("Session ID : " + sessionId + "<br/>");
	int sessionInter = session.getMaxInactiveInterval();
	out.print("Session Interval : " + sessionInter + "<br/>");
	out.print("===========<br/>");
	
	session.removeAttribute("mySessionName");
	Enumeration<String> enume = session.getAttributeNames();
	while(enume.hasMoreElements()){
		sName = enume.nextElement();
		sValue = session.getAttribute(sName).toString();
		out.print(sName + "    " + sValue + "<br/>");
	}
	out.print("=============<br/>");
	
	// session에 있는 모든 데이터 삭제
	session.invalidate();
	if(request.isRequestedSessionIdValid())
		out.print("session valid");
	else
		out.print("session invalid");
	%>

</body>
</html>