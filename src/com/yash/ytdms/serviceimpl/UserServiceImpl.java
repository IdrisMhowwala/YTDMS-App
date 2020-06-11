package com.yash.ytdms.serviceimpl;

import org.omg.CORBA.UserException;

import com.yash.ytdms.dao.UserDAO;
import com.yash.ytdms.daoimpl.UserDAOImpl;
import com.yash.ytdms.domain.User;
import com.yash.ytdms.service.UserService;
import com.yash.ytdms.util.JNDIUtil;

public class UserServiceImpl extends JNDIUtil implements UserService{
	private UserDAO userDAO;
	 public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}

	@Override
	public void registerUser(User user) throws UserException {
		user.setRole(3);
		userDAO.save(user);
		
	}
	
	

}
