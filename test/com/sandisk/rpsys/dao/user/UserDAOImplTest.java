package com.sandisk.rpsys.dao.user;

import java.sql.SQLException;

import org.junit.Test;

import com.sandisk.rpsys.entity.User;

public class UserDAOImplTest {

	@Test
	public void TestGetById() throws SQLException {
		User u = new UserDAOImpl().getById(1);
		System.out.println(u.toString());
	}
	
	@Test
	public void TestdeleteById() throws SQLException {

		System.out.println(new UserDAOImpl().deleteById(1014));
	}
	
	@Test
	public void TestInsert() throws SQLException {
		User user = new User(null, "hihi", "hoho", "heihei");
		System.out.println(new UserDAOImpl().insert(user));
	}
	
	@Test
	public void TestUpdateById() throws SQLException {
		User user = new User(null, "hixabhi", "hobasdho", "hesdfafihei");
		System.out.println(new UserDAOImpl().updateById(1010, user));
		
	}

}
