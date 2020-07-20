<%@page import="com.nextwin.ex.MemberDao"%>
<%@page import="com.nextwin.ex.MemberDto"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.nextwin.ex.MemberDto"/>
<jsp:setProperty name="dto" property="*"/>	<!-- DTO 객체에 주입 -->
<%
	dto.setrDate(new Timestamp(System.currentTimeMillis()));
	MemberDao dao = MemberDao.getInstance();
	if(dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXIST){
%>
	<script type="text/javascript">
		alert("아이디가 이미 존재합니다.");
		// 브라우저를 뒤로 돌려 다시 회원가입 페이지로 보냄
		history.back();
	</script>
<%
	}
	else{
		int ri = dao.insertMember(dto);
		if(ri == MemberDao.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id", dto.getId());
%>
		<script type="text/javascript">
			alert("회원가입을 축하합니다.");
			document.location.href = "login.jsp";
		</script>
<%
		}
		else{
%>
		<script type="text/javascript">
			alert("회원가입에 실패하였습니다.");
			document.location.href = "login.jsp";
		</script>
<%
		}
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