<%@page import="com.nextwin.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.nextwin.ex.MemberDto"/>
<jsp:setProperty name="dto" property="*"/>
<%
	MemberDao dao = MemberDao.getInstance();
	dto.setId((String)session.getAttribute("id"));
	int ri = dao.modifyMember(dto);
	
	if(ri == MemberDao.MEMBER_MODIFY_SUCCESS){
%>
	<script type="text/javascript">
		alert("회원 정보를 수정하였습니다.");
		document.location.href = "main.jsp";
	</script>
<%
	}
	else{
%>
	<script type="text/javascript">
		alert("회원 정보 수정에 실패하였습니다. 다시 시도해주세요.");
		history.back();
	</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>