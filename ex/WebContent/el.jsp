<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="com.nextwin.ex.Student" scope="page"/>
<jsp:setProperty name="student" property="name" value="홍길동"/>
<%
	student.setAge(19);
	student.setGrade(3);
%>
<jsp:setProperty name="student" property="studentNum" value="30"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${10}<br/>
	${99.98}<br/>
	${"ABC"}<br/>
	${true}<br/>
	
	${1 + 2}<br/>
	${1 / 2}<br/>
	${1 > 2}<br/>
	${1 < 2}<br/>
	${1 > 2 ? 1 : 2}<br/>
	${1 > 2 || 1 < 2}<br/>
	
	이름 : ${student.name}<br/>
	나이 : ${student.age}<br/>
	학년 : <jsp:getProperty property="grade" name="student"/><br/>
	번호 : <%=student.getStudentNum()%>

</body>
</html>