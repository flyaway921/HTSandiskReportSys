package com.sandisk.rpsys.dao.group;

import java.io.IOException;
import java.sql.SQLException;

import com.sandisk.rpsys.entity.Group;
import com.sandisk.rpsys.entity.User;

public interface IGroupDAO {
	
	public void insert( Group group) throws SQLException, IOException;
	public Group getById( int id) throws SQLException, IOException, ClassNotFoundException;
	public void deleteById( int id) throws SQLException;
	public void update( Group group) throws IOException, SQLException;
}
