package com.nextwin.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String uid = "c##hyeonqyu";
    private String upw = "oracle";
	
	private Connection connection;
	private Statement statement;
	ResultSet resultSet;
	
	HttpSession httpSession;
	
	private String name, id, pw, phone1, phone2, phone3, gender;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		httpSession = request.getSession();
		
		name = request.getParameter("name");
		id = (String)httpSession.getAttribute("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		if(pwConfirm()) {
			String query = "update member set name = '" + name + "', phone1 = '" + phone1 + "', phone2 = '" + phone2
							+ "', phone3 = '" + phone3 + "', gender = '" + gender + "' where id = '" + id + "'";
			System.out.println("query: " + query);
			
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, uid, upw);
				statement = connection.createStatement();
				int i = statement.executeUpdate(query);
				
				if(i == 1) {
					System.out.println("Update success");
					httpSession.setAttribute("name", name);
					response.sendRedirect("modifyResult.jsp");
				}
				else {
					System.out.println("Update fail");
					response.sendRedirect("modify.jsp");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(statement != null)
						statement.close();
					if(connection != null)
						connection.close();
				}
				catch(SQLException e) {}
			}
		}
	}
	
	private boolean pwConfirm() {
		String sessionPw = (String)httpSession.getAttribute("pw");
		
		if(sessionPw.equals(pw))
			return true;
		return false;
	}

}
