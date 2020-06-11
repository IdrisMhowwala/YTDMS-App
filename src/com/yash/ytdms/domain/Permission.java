package com.yash.ytdms.domain;

/**
 * 
 * This class is data traveller from layer to layer
 * 
 * @author rajpal.dodiya
 *
 */
public class Permission {
	/**
	 * Name of permission
	 */
	private String name;
	/**
	 * Id of permission pk
	 */
	private int id;
	/**
	 * Id of module in which Permission falls FK
	 */
	private int moduleId;

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
