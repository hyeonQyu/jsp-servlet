<%@page import="com.nextwin.ex.MemberDto"%>
<%@page import="com.nextwin.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDao dao = MemberDao.getInstance();
	int checkNum = dao.checkUser(id, pw);
	if(checkNum == -1){
%>
	<script type="text/javascript">
		alert("아이디가 존재하지 않습니다.");
		history.go(-1);
	</script>
<%	
	}
	else if(checkNum == 0){
%>
	<script type="text/javascript">
		alert("비밀번호가 틀립니다.");
		history.go(-1);
	</script>		
<%
	}
	else if(checkNum == 1){
		MemberDto dto = dao.getMember(id);
		
		if(dto == null){
%>
		<script type="text/javascript">
			alert("존재하지 않는 회원이거나 오류입니다. 다시 시도하세요.");
			history.go(-1);
		</script>
<%
		}
		else{
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("main.jsp");
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