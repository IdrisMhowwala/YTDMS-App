package com.yash.ytdms.dao;

import java.util.List;

import com.yash.ytdms.domain.Group;
import com.yash.ytdms.domain.User;

/**
 * this GroupDAO will be performing all the CRUD operation related to group
 * 
 * @author prateek.dubey
 *
 */

public interface GroupDAO {
	/**
	 * will return all the Group from Group table
	 * 
	 * @param userId
	 * 
	 * @return all the Group if found,otherwise null
	 */
	List<Group> findAllGroups(int userId);

	/**
	 * This update method will update the group information
	 * 
	 * @param group
	 *            to be updated
	 */
	void update(Group group);
	/**
	 * this method will check general group is created or not
	 * if not created then it will create and insert all trainees those who are not assigned anywhere else.
	 */
	void insert(Group group);

	/**
	 *  will return all the Group from Group table
	 * @param role 
	 * @return all the Group if found,otherwise null
	 */
	List<Group> findAll(int role);

	List<User> findById(int id);
}