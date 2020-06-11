package com.yash.ytdms.dao;

import java.util.List;

import com.yash.ytdms.domain.PermissionModule;

/**
 * This is repsonsible for all the CRUD operations related to permission module
 * @author rajpal.dodiya
 *
 */
public interface PermissionModuleDAO {
	/**
	 * This listAll function will return all the available Permission modules from database
	 * @return
	 */
	List<PermissionModule> listAll();

	/**
	 * This will add the module in the database
	 * @param module is the module to be added
	 */
	void addModule(PermissionModule module);
	

	/**
	 * This will list all the  present modules
	 * @return listModules
	 */
	List<PermissionModule> listGroup();

	/**
	 * This is used to get group name and description of group
	 * @param id is the id of group
	 * @return permissionModule
	 */
	PermissionModule get(int id);
}
