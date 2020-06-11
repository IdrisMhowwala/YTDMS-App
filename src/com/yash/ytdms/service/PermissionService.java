package com.yash.ytdms.service;

import java.util.List;

import com.yash.ytdms.domain.Permission;

/**
 * This will contain all business related logic for Permission
 * @author rajpal.dodiya
 *
 */
public interface PermissionService {
	
	/**
	 * This will return the all permissions by role 
	 * @return the permissions for specific role
	 */
	List<Permission> permissionsByRole(int moduleId);

	/**
	 * This will return list the permissions
	 * @param groupId is the id of module to which permissions belond
	 * @return permissions of selected module
	 */
	public List<Permission> getPermissionService(int groupId);

	/**
	 * This will return the module Name
	 * @param groupId is the id of module 
	 * @return name of module on basis of group id.
	 */
	public String getGroupName(int groupId);

	/**
	 * This will add the permissionin database
	 * @param permission is the permission to be added
	 */
	public void addPermission(Permission permission);
	
	/**
	 * This will return object of type Permisiion 
	 * @param permissionId is the id of the permission
	 * @return permission object
	 */
	public Permission getPermission(int permissionId);

	/**
	 * This will update the permission in database
	 * @param permissionName is the name to be updated
	 */
	public void editPermission(Permission permissionName);

	/**
	 * This will remove the particular permission from the database
	 * @param permissionId is the id of the permission to be removed
	 */
	public void remove(int permissionId);
}
