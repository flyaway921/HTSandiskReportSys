package com.sandisk.rpsys.dao.group;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.sandisk.rpsys.entity.Group;
import com.sandisk.rpsys.entity.User;

public class GroupDAOImplTest {
	@Test
	public void TestInsertGroup() throws SQLException, IOException{
		Group g = new Group();
		ArrayList<User> members = new ArrayList<User>();
		members.add(new User(1, "adsb", "bbv", "badf"));
		members.add(new User(2, "asdfdsb", "bsdfbv", "bsadfadf"));
		g.setName("Cassandra-Dev");
		g.setMembers(members);
		new GroupDAOImpl().insert(g);
	}
	
	@Test
	public void TestGetById() throws ClassNotFoundException, SQLException, IOException{
		Group g = new GroupDAOImpl().getById(12);
		System.out.println(g.toString());
	}
	
	@Test
	public void TestUpdate() throws ClassNotFoundException, SQLException, IOException{
		Group g = new Group();
		g.setId(12);
		ArrayList<User> members = new ArrayList<User>();
		members.add(new User(1, "adsb", "bbv", "badf"));
		members.add(new User(2, "asdfdsb", "bsdfbv", "bsadfadf"));
		g.setMembers(members);
		g.setName("QA-Team");
		new GroupDAOImpl().update(g);
		TestGetById();
	}
	
	@Test
	public void TestDeleteById() throws ClassNotFoundException, SQLException, IOException{
		new GroupDAOImpl().deleteById(13);
	}
}
