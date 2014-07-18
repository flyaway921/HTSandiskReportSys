package com.sandisk.rpsys.service.user;

import java.sql.SQLException;

import com.sandisk.rpsys.dao.user.UserDAOImpl;
import com.sandisk.rpsys.entity.User;

public class UserServiceBean implements IUserService{

	public boolean login(String username, String pwd) {
		try {
			String passWord = new UserDAOImpl().getByName(username).getPwd();
			if(passWord.equals(pwd))
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean register() {
		// TODO Auto-generated method stub
		return false;
	}

	public void changePwd(String newPwd) {
		// TODO Auto-generated method stub
		
	}

	public void changeMail(String newMail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByName(String name) {
		try {
			User result = new UserDAOImpl().getByName(name);
			if(result != null)
				return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
