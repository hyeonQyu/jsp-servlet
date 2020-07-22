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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	
	아이디 : <%= id %><br/>
	비밀번호 : <%= pw %><br/>
	
	<hr/>
	
	아이디 : ${ param.id }<br/>
	비밀번호 : ${ param.pw }<br/>
	아이디 : ${ param["id"] }<br/>
	비밀번호 : ${ param["pw"] }<br/>
	
	<hr/>
	
	applicationScope : ${ applicationScope.application_name }<br/>
	sessionScope : ${ sessionScope.session_name }<br/>
	pageScope : ${ pageScope.pageContext_name }<br/>
	requestScope : ${ requestScope.request_name }<br/>
	
	<hr/>
	
	<%
		out.print(getServletContext().getInitParameter("id") + "<br/>");
		out.print(getServletContext().getInitParameter("pw") + "<br/>");
	%>
	
	<hr/>
	
	context 초기화 파라미터<br/>
	${ initParam.id }<br/>
	${ initParam.pw }<br/>

</body>
</html>