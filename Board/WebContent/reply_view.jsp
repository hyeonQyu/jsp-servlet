<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="reply.do" method="post">
			<input type="hidden" name="id" value="${reply_view.id}">
			<input type="hidden" name="group" value="${reply_view.group}">
			<input type="hidden" name="step" value="${reply_view.step}">
			<input type="hidden" name="indent" value="${reply_view.indent}">
			<tr>
				<td>번호</td>
				<td>${reply_view.id}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${reply_view.hit}</td>
			</tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="[답변] ${reply_view.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="content">    ----------------------    ${reply_view.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="답변"> <a href="list.do">목록</a></td>
			</tr>
		</form>
	</table>

</body>
</html>