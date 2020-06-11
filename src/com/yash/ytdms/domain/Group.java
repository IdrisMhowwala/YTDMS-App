package com.yash.ytdms.domain;

import java.util.Date;

public class Group {
	/**
	 * group id ,pk
	 */
	private int id;
	/**
	 * id of user
	 */
	private int userId;
	/**
	 * name of group
	 */
	private String name;
	/**
	 * starting date of group creation
	 */
	private Date start_date;
	/**
	 * end date of group
	 */
	private Date end_date;
	/**
	 * status of group 1:Activate 2:Deactivate
	 */
	private int status;
	/**
	 * description of group
	 */
	private String description;
	/**
	 * name of the user who has created the group
	 */
	private String createdBy;
	/**
	 * name of the user who has updated the group
	 */
	private String updatedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updateBy) {
		this.updatedBy = updateBy;
	}

}
