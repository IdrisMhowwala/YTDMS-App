package com.yash.ytdms.domain;

import java.sql.Date;

public class Notification {
	
	private int id;
	private String message;
	private int generatedBy;
	private int sentTo;
	private Date sentDate;
	private int n_operation_type;
	private int n_item_type;
	private int n_item_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getGeneratedBy() {
		return generatedBy;
	}
	public void setGeneratedBy(int generatedBy) {
		this.generatedBy = generatedBy;
	}
	public int getSentTo() {
		return sentTo;
	}
	public void setSentTo(int sentTo) {
		this.sentTo = sentTo;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public int getN_operation_type() {
		return n_operation_type;
	}
	public void setN_operation_type(int n_operation_type) {
		this.n_operation_type = n_operation_type;
	}
	public int getN_item_type() {
		return n_item_type;
	}
	public void setN_item_type(int n_item_type) {
		this.n_item_type = n_item_type;
	}
	public int getN_item_id() {
		return n_item_id;
	}
	public void setN_item_id(int n_item_id) {
		this.n_item_id = n_item_id;
	}
	
		
	}
