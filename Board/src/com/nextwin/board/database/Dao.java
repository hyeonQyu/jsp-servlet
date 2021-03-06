package com.nextwin.board.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
	
	public ArrayList<Dto> getList(){
		ArrayList<Dto> dtos = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * from mvc_board order by bGroup desc, bStep asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("bId");
				String name = resultSet.getString("bName");
				String title = resultSet.getString("bTitle");
				String content = resultSet.getString("bContent");
				Timestamp date = resultSet.getTimestamp("bDate");
				int hit = resultSet.getInt("bHit");
				int group = resultSet.getInt("bGroup");
				int step = resultSet.getInt("bStep");
				int indent = resultSet.getInt("bIndent");
				
				Dto dto = new Dto(id, name, title, content, date, hit, group, step, indent);
				dtos.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	public Dto getContentView(String id) {
		Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String name = resultSet.getString("bName");
				String title = resultSet.getString("bTitle");
				String content = resultSet.getString("bContent");
				Timestamp date = resultSet.getTimestamp("bDate");
				int hit = resultSet.getInt("bHit");
				int group = resultSet.getInt("bGroup");
				int step = resultSet.getInt("bStep");
				int indent = resultSet.getInt("bIndent");
				
				dto = new Dto(Integer.parseInt(id), name, title, content, date, hit, group, step, indent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public void modify(Dto dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "update mvc_board set bTitle = ?, bContent = ? where bId = ?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, dto.getTitle());
			preparedStatement.setString(2, dto.getContent());
			preparedStatement.setInt(3, dto.getId());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void write(Dto dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
					+ "values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getTitle());
			preparedStatement.setString(3, dto.getContent());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "delete from mvc_board where bId=?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void upHit(Dto dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "update mvc_board set bHit=? where bId=?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, dto.getHit() + 1);
			preparedStatement.setInt(2, dto.getId());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Dto getReplyView(int id) {
		Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * from mvc_board where bId=?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				id = resultSet.getInt("bId");
				String name = resultSet.getString("bName");
				String title = resultSet.getString("bTitle");
				String content = resultSet.getString("bContent");
				Timestamp date = resultSet.getTimestamp("bDate");
				int hit = resultSet.getInt("bHit");
				int group = resultSet.getInt("bGroup");
				int step = resultSet.getInt("bStep");
				int indent = resultSet.getInt("bIndent");
				
				dto = new Dto(id, name, title, content, date, hit, group, step, indent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return dto;
	}
	
	public void reply(Dto dto) {
		replyShape(dto.getGroup(), dto.getStep());
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
					+ "values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getTitle());
			preparedStatement.setString(3, dto.getContent());
			preparedStatement.setInt(4, dto.getGroup());
			preparedStatement.setInt(5, dto.getStep() + 1);
			preparedStatement.setInt(6, dto.getIndent() + 1);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void replyShape(int group, int step) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "update mvc_board set bStep=bStep+1 where bGroup=? and bStep>?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, group);
			preparedStatement.setInt(2, step);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
