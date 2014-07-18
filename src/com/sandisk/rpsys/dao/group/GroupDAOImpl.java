package com.sandisk.rpsys.dao.group;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sandisk.rpsys.entity.Group;
import com.sandisk.rpsys.entity.User;
import com.sandisk.rpsys.jdbc.util.DBUtil;

public class GroupDAOImpl implements IGroupDAO{

	public void insert(Group group) throws SQLException, IOException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into _group ( id, name, members ) values ( ?, ?, ? )";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setString(2, group.getName());
			//serilize the members to table _group
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ObjectOutputStream ops = new ObjectOutputStream(baos);
		    ops.writeObject(group.getMembers());
		    ops.close();                   
		    baos.close();  
			pstmt.setBytes(3, baos.toByteArray());
			
			int n = pstmt.executeUpdate();
			System.out.println(n+ " reocrd inserted");
		} catch (SQLException e) {
			System.out.println("error at insert group");
			e.printStackTrace();
		}finally{
			conn.close();
		}
	}

	public Group getById(int id) throws SQLException, IOException, ClassNotFoundException {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from _group where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			//deserilize the members get from db
			Group result  = new Group();
			result.setId(rs.getInt("id"));
			result.setName(rs.getString("name"));
			byte[] props =  rs.getBytes("members");
            ByteArrayInputStream baos = new ByteArrayInputStream(props);
            ObjectInputStream ops = new ObjectInputStream(baos);
            Object ob = ops.readObject();
            if ( ob != null )
            {
                result.setMembers((ArrayList<User>)ob);
            }
            ops.close();
            baos.close();
            baos = null;
			return result;
		} catch (SQLException e) {
			System.out.println("error at get group");
			e.printStackTrace();
		}finally{
			rs.close();
			conn.close();
		}
		return null;
	}

	public void update(Group group) throws IOException, SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update _group set name = ? , members = ? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, group.getName());
			pstmt.setInt(3, group.getId());
			//serilize the members to table _group
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ObjectOutputStream ops = new ObjectOutputStream(baos);
		    ops.writeObject(group.getMembers());
		    ops.close();                   
		    baos.close();  
			pstmt.setBytes(2, baos.toByteArray());
			
			int n = pstmt.executeUpdate();
			System.out.println(n+ " reocrd updated");
		} catch (SQLException e) {
			System.out.println("error at update group");
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
	}

	public void deleteById(int id) throws SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from _group where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int n = pstmt.executeUpdate();
			System.out.println(n + " reocrd deleted");
			
		} catch (SQLException e) {
			System.out.println("error at delete group");
			e.printStackTrace();
		}finally{
			conn.close();
		}
	}
	

}
