<%@ page import="java.util.Arrays"%>
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
		int[] arr = {5, 2, 3, 4, 1};
		Arrays.sort(arr);
		out.print(Arrays.toString(arr));
	%>

</body>
</html>