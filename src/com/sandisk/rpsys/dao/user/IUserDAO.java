package com.sandisk.rpsys.dao.user;

import java.sql.SQLException;

import com.sandisk.rpsys.entity.User;

public interface IUserDAO {
	
	public boolean insert(User user) throws SQLException;
	
	public boolean deleteById(int id) throws SQLException;
	
	public User getById(int id) throws SQLException;
	
	public User getByName(String name) throws SQLException;
	
	public boolean updateById(int id, User user) throws SQLException;
}
