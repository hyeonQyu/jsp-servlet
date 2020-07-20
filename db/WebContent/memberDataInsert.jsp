<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "c##hyeonqyu";
	String upw = "oracle";
	%>
	
	<%
	try{
		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, upw);
		String sql = "insert into memberforpre (name, id, pw, phone) values (?, ?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, "홍길동");
		pstmt.setString(2, "hong12");
		pstmt.setString(3, "1234");
		pstmt.setString(4, "010-1111-2222");
		
		if(pstmt.executeUpdate() == 1)
			out.print("insert success");
		else{
			out.print("insert fail");
			return;
		}
		
		pstmt.setString(1, "김영미");
		pstmt.setString(2, "ym1111");
		pstmt.setString(3, "1331");
		pstmt.setString(4, "010-1221-2333");
		
		if(pstmt.executeUpdate() == 1)
			out.print("insert success");
		else{
			out.print("insert fail");
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
			return;
		}
		
		pstmt.setString(1, "박철수");
		pstmt.setString(2, "cscscs");
		pstmt.setString(3, "1234512");
		pstmt.setString(4, "010-3333-1234");
		
		if(pstmt.executeUpdate() == 1)
			out.print("insert success");
		else{
			out.print("insert fail");
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
			return;
		}
		
		pstmt.setString(1, "이자용");
		pstmt.setString(2, "lee1313");
		pstmt.setString(3, "1313");
		pstmt.setString(4, "010-1313-1313");
		
		if(pstmt.executeUpdate() == 1)
			out.print("insert success");
		else{
			out.print("insert fail");
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
			return;
		}
		
		
	} catch(Exception e){
		e.printStackTrace();
	} finally{
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}
	%>
	
	<br/>

</body>
</html>