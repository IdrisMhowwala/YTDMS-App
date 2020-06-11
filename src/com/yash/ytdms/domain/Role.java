package com.yash.ytdms.domain;

import java.util.List;

/**
 * This role is data traveller from one layer to another
 * 
 * @author rajpal.dodiya
 *
 */
public class Role {
	/**
	 * This is id of role PK
	 */
	private Integer id;
	/**
	 * This is name of role
	 */
	private String name;
	/**
	 * List of all the permission modules for a specified role
	 */
	private List<PermissionModule> permissionModules;
	
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	private int moduleId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PermissionModule> getPermissionModules() {
		return permissionModules;
	}
	public void setPermissionModules(List<PermissionModule> permissionModules) {
		this.permissionModules = permissionModules;
	}

}
