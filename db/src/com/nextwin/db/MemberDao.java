package com.nextwin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String uid = "c##hyeonqyu";
//	private String upw = "oracle";
	private DataSource dataSource;
	
	public MemberDao() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18c");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDto> memberSelect(){
		ArrayList<MemberDto> dtos = new ArrayList<>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//con = DriverManager.getConnection(url, uid, upw);
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from member");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				
				MemberDto dto = new MemberDto(name, id, pw, phone1, phone2, phone3, gender);
				dtos.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();				
			} catch(Exception e) {}
		}
		
		return dtos;
	}

}
