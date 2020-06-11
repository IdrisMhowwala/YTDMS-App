package com.yash.ytdms.dao;

import java.util.List;

import com.yash.ytdms.domain.Category;

public interface CategoryDAO {

	/**
	 * This save method will save the category in categories table
	 * 
	 * @param category to be saved
	 * @return 
	 */
	int save(Category category);

	/**
	 * This update method will update category in categories table
	 * 
	 * @param category to be updated
	 */
	void update(Category category);

	/**
	 * This delete method will delete category in categories table
	 * 
	 * @param category to be deleted
	 */
	void delete(Category category);

	/**
	 * This delete method will delete category in categories table based on provided
	 * id
	 * 
	 * @param id of the category to be deleted.
	 */
	void delete(int id);

	/**
	 * This findAll method will return the list of all the category available in categories table
	 * @return list of categories
	 */
	List<Category> findAll();
	
	/**
	 *This method will change status 
	 * @param id
	 * @param visibilityStatus
	 */
	void changeStatus(int id, int visibilityStatus);
   
   /**
    * Find method will return the category based on categoryId.
    * @param categoryId
    * @return
    */
	Category find(int categoryId);
	/**
	 * This findAll method will return the list of all the category available in categories table corresponding to provided Id
	 * @param managerUserId is the id corresponding to which list is to be found
	 * @return list of categories
	 */
	List<Category> findAll(int managerUserId);
}
