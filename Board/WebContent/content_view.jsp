<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${content_view.title}</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify.do" method="post">
			<input type="hidden" name="id" value="${content_view.id}">
			<tr>
				<td>번호</td>
				<td>${content_view.id}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${content_view.hit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${content_view.name}></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${content_view.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="content">${content_view.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정"> &nbsp;&nbsp;
				<a href="list.do">목록 보기</a> &nbsp;&nbsp;
				<a href="delete.do?id=${content_view.id}">삭제</a> &nbsp;&nbsp;
				<a href="reply_view.do?id=${content_view.id}">답변</a></td>
			</tr>
		</form>
	</table>

</body>
</html>