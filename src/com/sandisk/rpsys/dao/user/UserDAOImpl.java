package com.sandisk.rpsys.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sandisk.rpsys.entity.User;
import com.sandisk.rpsys.jdbc.util.DBUtil;

public class UserDAOImpl implements IUserDAO{

	public boolean insert(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into user (id, username, pwd, mail) values (null, ?, ?, ?)";
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getMail());
			int n = pstmt.executeUpdate();
			if(n == 1){
				System.out.println(n+" record inserted");
				return true;
			}else
				return false;
		} catch (SQLException e) {
			System.out.println("error at insert user");
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return false;
		
	}

	public boolean deleteById(int id) throws SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from user where id = ?";
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int n = pstmt.executeUpdate();
			if(n == 1){
				System.out.println(n+" record deleted");
				return true;
			}else
				return false;
		} catch (SQLException e) {
			System.out.println("error at read report");
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return false;
		
	}

	public User getById(int id) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from user where id = ?";
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			User result = new User();
			result.setUserId(rs.getInt("id"));
			result.setUserName(rs.getString("username"));
			result.setPwd(rs.getString("pwd"));
			result.setMail(rs.getString("mail"));
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs.close();
			conn.close();
		}
		return null;
	}
	
	public User getByName(String name) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from user where username = ?";
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			User result = new User();
			result.setUserId(rs.getInt("id"));
			result.setUserName(rs.getString("username"));
			result.setPwd(rs.getString("pwd"));
			result.setMail(rs.getString("mail"));
			return result;
		} catch (SQLException e) {
			System.out.println("error at get user by name");
			e.printStackTrace();
		}finally{
			rs.close();
			conn.close();
		}
		return null;
	}

	public boolean updateById(int id, User user) throws SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update user set username = ?, pwd = ?, mail = ? where id = ?";
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getMail());
			pstmt.setInt(4, id);
			int n = pstmt.executeUpdate();
			if(n == 1){
				System.out.println(n+" record updated");
				return true;
			}
			else
				return false;
		} catch (SQLException e) {
			System.out.println("error at read report");
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return false;
	}



}
