<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="varName" value="varValue"/>
	varName : <c:out value="${ varName }"/>
	<br/>
	<c:remove var="varName"/>
	varName : <c:out value="${ varName }"/></h3>
	
	<hr/>
	
	<c:catch var="error">
		<%= 2/0 %>
	</c:catch>
	<br/>
	<c:out value="${ error }"/>
	
	<hr/>
	
	<c:if test="${ 1 + 2 == 3 }">
		1 + 2 = 3
	</c:if>
	<c:if test="${ 1 + 2 != 3 }">
		1 + 2 != 3
	</c:if>
	
	<hr/>
	
	<c:forEach var="i" begin="0" end="30" step="5">
		${ i }
	</c:forEach>

</body>
</html>