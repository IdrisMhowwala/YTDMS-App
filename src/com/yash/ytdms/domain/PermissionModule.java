package com.yash.ytdms.domain;

import java.util.List;

/**
 * This PermissionModule is data traveller from one level to another
 * 
 * @author rajpal.dodiya
 *
 */

public class PermissionModule {

	/**
	 * This is the id of the permission Module
	 */
	private int id;

	/**
	 * This is the name of the particular permission Module
	 */
	private String name;

	/**
	 * This will be the description displayed to the super user of module
	 */
	private String description;

	/**
	 * This is the list of Permissions
	 */
	private List<Permission> permissions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
