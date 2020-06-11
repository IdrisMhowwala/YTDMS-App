package com.yash.ytdms.service;

import java.util.List;

import com.yash.ytdms.domain.Role;
import com.yash.ytdms.exception.RoleException;

/**
 * This will contain all business related operation of Role
 * @author rajpal.dodiya
 *
 */
public interface RoleService {
	
	/**
	 * This is list of all roles 
	 * @return list of roles
	 */
	List<Role> listRoles();

	/**
	 * This will assign permissions to specefic role of a specific module
	 * @param role is the role to which permissions will be assigned
	 */
	Role assignPermissionsToRole(Role role) throws RoleException;

	/**
	 * This will add the role provided by user
	 * @param role is the role to be added
	 */
	void addRole(Role role);
	
	/**
	 * This will get the Role
	 * @param roleId is the id of the role 
	 * @return Role object 
	 */
	public Role getRoleById(int roleId);

}
