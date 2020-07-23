package com.nextwin.board.database;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Dao {
	
	private DataSource dataSource;
	
	public Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
