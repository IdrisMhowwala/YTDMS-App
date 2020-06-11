package com.yash.ytdms.dao;


import java.util.List;

import com.yash.ytdms.domain.User;


public interface UserDAO {
	
	/**
	 * This save method will save the user in users
	 * 
	 * @param user to be saved
	 */
	void save(User user);
	
	/**
	 * This findAll method will return the list of all the group available in groups
	 * 
	 * @return
	 */
	List<User> findAll();

	
	void update(User user);
	void delete(User user);
}