package com.sandisk.rpsys.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sandisk.rpsys.dao.user.UserDAOImpl;
import com.sandisk.rpsys.dto.UserDTO;
import com.sandisk.rpsys.service.user.UserServiceBean;

public class UserAction extends ActionSupport {
	
	private static Logger logger = Logger.getLogger(UserAction.class);
	
	private UserDTO user;

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public UserDTO getUser() {
		return user;
	}

	public String login() throws Exception {
		logger.info(user.getUsername() + " is loging in.");
		boolean loginSuccess;
		loginSuccess = new UserServiceBean().login(user.getUsername(), user.getPassword());
		ActionContext context = ActionContext.getContext();
		// put user infomation into session
		context.getSession().put("user",user);
		if(loginSuccess)
			return SUCCESS;
		else
			return "fail";
	}
	
}
