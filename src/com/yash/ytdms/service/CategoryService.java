package com.yash.ytdms.service;

import java.util.List;

import com.yash.ytdms.domain.Category;
import com.yash.ytdms.exception.CategoryDescriptionException;
import com.yash.ytdms.exception.CategoryNameException;

/**
 * This is service class which have all category related services and it will interact with dao layer for crud operations
 * @author yash.nahar
 *
 */
public interface CategoryService {
	/**
	 * ACTIVE status representing visibility_status of category
	 */
	int ACTIVE = 1;
	/**
	 * BLOCK status representing visibility_status of category
	 */
	int BLOCK = 2;
	/**
	 * APPROVED status representing permission_status of category
	 */
	int APPROVED = 1;
	/**
	 * PENDING status representing permission_status of category
	 */
	int PENDING = 2;
	/**
	 * REJECT status representing permission_status of category
	 */
	int REJECT = 3;
	
	int createCategory(Category category) throws CategoryNameException, CategoryDescriptionException;
	
	public List<Category> listCategories();
	 
	void changeVisbilityStatus(int id, int visibilityStatus);
	
	/**
	 * This will add the updated category into database.
	 * @param category
	 */
	void addUpdatedCategory(Category category)throws CategoryNameException,CategoryDescriptionException;
	
	/**
	 * This will delete the category from database.
	 * @param category
	 */
	void removeCategory(Category category);

	/**
	 * This will retrieve category from database.
	 * @param categoryId
	 * @return
	 */
	Category getCategory(int categoryId);
	
	/**
	 * This method returns list of category which are added by trainers working under the perticular logged In Training manager
	 * @param managerUserId is Id of Logged in Manager 
	 * @return list of category
	 */
	List<Category> getTMCategories(int managerUserId);
	
	/**
	 * This method approves a particular category
	 * @param categoryId is the id of category to be approved
	 */
	void approveCategory(int categoryId);

	/**
	 * This method rejects a perticular category
	 * @param categoryId is the id of category to be rejected
	 */
	void rejectCategory(int categoryId, String rejectionMessage);

	/**
	 * This method gets userId according to categoryId
	 * @param categoryId is id corresponding to which user id is required
	 */
	int getUserId(int categoryId);
	
}
