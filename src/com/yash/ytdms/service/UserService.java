package com.yash.ytdms.service;

import org.omg.CORBA.UserException;

import com.yash.ytdms.domain.User;

public interface UserService {
	void registerUser(User user) throws UserException;
	

}
