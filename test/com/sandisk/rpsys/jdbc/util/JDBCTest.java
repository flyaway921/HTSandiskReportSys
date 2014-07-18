package com.sandisk.rpsys.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import com.sandisk.rpsys.entity.User;
import com.sandisk.rpsys.jdbc.util.DBUtil;

public class JDBCTest {
	@Test
	public void insert() throws SQLException {
		Connection conn = null;
		try {
			 conn = DBUtil.getConnection();
			String sql = "insert into user(id,username,pwd,mail)"
					+ "values(null,'zhaowu','12345','xxx@aa')";
			Statement stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if (n == 1) {
				System.out.println("inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
		}
	}
	
	@Test
	public void select() {
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from user";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setUserId(new Integer(rs.getInt(1)));
				user.setUserName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setMail(rs.getString(4));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void delete(){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "delete from report where id=2";
			Statement stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			
			if(n ==1){
				System.out.println("delete success");
			}else
				System.out.println("delete "+n+" records");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
