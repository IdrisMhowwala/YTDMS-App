package com.yash.ytdms.service;

import java.util.List;



import com.yash.ytdms.domain.Group;
import com.yash.ytdms.exception.GroupException;
import com.yash.ytdms.exception.GroupStatusException;

/**
 * This GroupService interface will be performing business service on Group
 * 
 * @author prateek.dubey
 *
 */
public interface GroupService {
	   int ACTIVE = 1;
	   int BLOCKED = 2;
	
	/**
	 * This method will edit the Group information
	 * 
	 * @param group
	 *            to be edited
	 */
	void editGroup(Group group);

	/**
	 * This method will display all the groups on the basis of userId
	 * 
	 * @param userId
	 *            id of the user
	 * @return list of groups
	 */
	List<Group> listGroup(int userId);
	/**
	 * this method will create a group and insert it into group table
	 * @param group group to be created
	 */
	void createMyGroup(Group group);
	/**
	 * this method will create a general group
	 */
	void createGeneralGroup();

	List<Group> listGroups(int role);

	void updateGroup(int idOfGroup, int idOfTrainee);

	void changeStatus(int status, int id) throws GroupStatusException;

}
