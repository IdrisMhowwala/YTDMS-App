
package com.yash.ytdms.domain;

import java.sql.Date;

/**
 * This is model class which is used for transfer of data from one layer to another
 * Layer can be dao, controller or service 
 * @author yash.nahar
 *
 */
public class Category {
	/**
	 * This is category id and it is primary key for categories table
	 */
	private int id;
	
	/**
	 *This is name of category.it can be java,ios or anything from user choice 
	 */
	private String name;
	/**
	 *This is description for category. 
	 */
	private String description;
	/**
	 * This is creation date for category and store date when category is created
	 */
	private Date creation_date;
	/**
	 * This is visibility status of category and it can be one from active/publish or block
	 * By default it will be block
	 * 1->
	 */
	private int visibility_status;
	/**
	 * This is permission status of category and can be approved or pending or reject
	 * By default it will be pending
	 */
	private int permission_status;
	/**
	 * This is userId and will act as foreign key in categories table and primary key of users table
	 */
	private int userId;
	
	/**
	 * This is rejectionMessage for user whose visibility status is set as reject by trainning manager
	 */
	private String rejectionMessage;
	
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
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public int getVisibility_status() {
		return visibility_status;
	}
	public void setVisibility_status(int visibility_status) {
		this.visibility_status = visibility_status;
	}
	public int getPermission_status() {
		return permission_status;
	}
	public void setPermission_status(int permission_status) {
		this.permission_status = permission_status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRejectionMessage() {
		return rejectionMessage;
	}
	public void setRejectionMessage(String rejectionMessage) {
		this.rejectionMessage = rejectionMessage;
	}
}
