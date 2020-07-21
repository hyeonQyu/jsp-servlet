package com.nextwin.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	
	public static final int MEMBER_NONEXIST = 0;
	public static final int MEMBER_EXIST = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_FAIL = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
		
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	private MemberDao() {}
	
	// 데이터베이스에 회원 정보 추가
	public int insertMember(MemberDto dto) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into members (id, pw, name, eMail, rdate, address) values (?, ?, ?, ?, ?, ?)";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setTimestamp(5, dto.getrDate());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeUpdate();
			
			ri = MEMBER_JOIN_SUCCESS;
		} catch (Exception e) {
			ri = MEMBER_JOIN_FAIL;
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return ri;
	}
	
	// 아이디 중복 확인
	public int confirmId(String id) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from members where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
				ri = MEMBER_EXIST;
			else
				ri = MEMBER_NONEXIST;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return ri;
	}
	
	// 로그인을 제대로 했는지 확인
	public int checkUser(String id, String pw) {
		int ri = 0;
		String dbPw;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pw from members where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			// id 존재
			if(rs.next()) {
				dbPw = rs.getString("pw");
				if(dbPw.equals(pw))
					ri = MEMBER_LOGIN_SUCCESS;
				else
					ri = MEMBER_LOGIN_PW_FAIL;
			}
			// 회원이 아님
			else {
				ri = MEMBER_LOGIN_IS_NOT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return ri;
	}
	
	// 회원 정보 반환
	public MemberDto getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from members where id = ?";
		MemberDto dto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDto();
				dto.setId(id);
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.seteMail(rs.getString("eMail"));
				dto.setAddress(rs.getString("address"));
				dto.setrDate(rs.getTimestamp("rDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				pstmt.close();
			} catch (Exception e) {}
			try {
				con.close();
			} catch (Exception e) {}
		}
		
		return dto;
	}
	
	private Connection getConnection() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18c");
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
