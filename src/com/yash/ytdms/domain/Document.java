package com.yash.ytdms.domain;

/**
 * This Document domain works as data traveler from layer to layer 
 * @author samay.jain
 *
 */
public class Document {
	
	/**
	 * This is the unique id for document
	 * it is primary key and auto generated
	 */
	private int id;
	
	/**
	 * This is the unique id for the section 
	 * it is FK
	 */
	private int sectionId;
	
	/**
	 * This is the unique id for the Category
	 * it is FK
	 */
	private int categoryId;
	
	/**
	 * This is the unique id of the user
	 * it is FK
	 */
	private int userId;
	
	/**
	 * This is the title of the Document  
	 */
	private String title;
	
	/**
	 * content of the Document
	 */
	private String content; 
	
	/**
	 * status of the document 
	 * 1 - enable
	 * 0 - disable
	 */
	private int status;

	/**
	 * document hide status
	 * 1 - hidden
	 * 0 - Unhide
	 */
	private int hide;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getHide() {
		return hide;
	}

	public void setHide(int hide) {
		this.hide = hide;
	}



}
