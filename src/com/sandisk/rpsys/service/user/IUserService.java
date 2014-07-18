package com.sandisk.rpsys.service.user;

import com.sandisk.rpsys.entity.User;

public interface IUserService {
	
	public boolean login(String username, String pwd);
	public boolean logout();
	public boolean register();
	public void changePwd(String newPwd);
	public void changeMail(String newMail);
	public User findByName(String name);
	
}
