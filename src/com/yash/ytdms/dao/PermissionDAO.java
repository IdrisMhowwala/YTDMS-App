package com.yash.ytdms.dao;

import java.util.List;

import com.yash.ytdms.domain.Permission;

/**
 * This is responsible for all crusd opoerations related to Permission.
 * @author rajpal.dodiya
 *
 */
public interface PermissionDAO {
	
	/**
	 * This will return list of permissions for a specific role
	 * @param roleId is the id of the role selected
	 * @param moduleId is the id of the module selected
	 * @return list of selected permissions
	 */
	List<Permission> permissionsByRole(int moduleId);

	/**
	 * will list all the permissions with respect to the module id
	 * @param moduleId
	 * @return
	 */

	List<Permission> list(int moduleId);
/**
 * name of the group is shown with respect to its groupId
 * @param groupId
 * @return
 */
	String get(int groupId);
	/**
	 * All the permissions of a particular groupId are shown
	 * @param groupId
	 * @return
	 */
	
	Permission getAll(int groupId);
	/**
	 * This is used to insert a particular permissions
	 * @param permission to be inserted
	 */
	void insert(Permission permission);

	/**
	 * This is used to update the permission
	 * @param permissionName whose permission is  to be updated
	 */
	void update(Permission permissionName);

	/**
	 * This is used to delete the permission
	 * @param permissionId is id of permission which is  to be deleted
	 */
	void delete(int permissionId);
}
