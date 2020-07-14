<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
		int i = 10;
		String s = "ABC";
		
		public int sum(int a, int b){
			return a + b;
		}
	%>

	<%= i %><br/>
	<%= s %><br/>
	<%= sum(1, 5) %><br/>

</body>
</html>