/**
 * 
 */
package com.yash.ytdms.serviceimpl;

import java.sql.Date;
import java.util.List;

import com.yash.ytdms.dao.CategoryDAO;
import com.yash.ytdms.daoimpl.CategoryDAOImpl;
import com.yash.ytdms.domain.Category;
import com.yash.ytdms.domain.Test;
import com.yash.ytdms.exception.CategoryDescriptionException;
import com.yash.ytdms.exception.CategoryNameException;
import com.yash.ytdms.exception.TestException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.util.ValidationUtil;

/**
 * This class have implementation of CategoryService interface and have all
 * services related to category
 * 
 * @author yash.nahar
 */
public class CategoryServiceImpl implements CategoryService {

	CategoryDAO categoryDAO = null;

	public CategoryServiceImpl() {
		categoryDAO = (CategoryDAO) ObjectFactory.getObject(CategoryDAO.class);
	}

	@Override
	public int createCategory(Category category) throws CategoryNameException, CategoryDescriptionException {
		category.setVisibility_status(BLOCK);
		category.setPermission_status(PENDING);
		category.setCreation_date(new Date(System.currentTimeMillis()));
		if (ValidationUtil.validateLength(category.getName(), 100) && !(category.getName().isEmpty())) {
			throw new CategoryNameException("Category name must be between 1 and 100 characters");
		} else if (ValidationUtil.validateLength(category.getDescription(), 100)
				&& !(category.getDescription().isEmpty())) {
			throw new CategoryDescriptionException("Category description must be between 1 and 100 characters");
		} else {
			return categoryDAO.save(category);
		}
		
	}

	@Override
	public List<Category> listCategories() {
		return categoryDAO.findAll();

	}

	@Override
	public void changeVisbilityStatus(int id, int visibilityStatus) {
		if (visibilityStatus == ACTIVE) {
			categoryDAO.changeStatus(id, BLOCK);
		} else if (visibilityStatus == BLOCK) {
			categoryDAO.changeStatus(id, ACTIVE);
		}

	}

	@Override
	public void addUpdatedCategory(Category category) throws CategoryNameException, CategoryDescriptionException {
		if (ValidationUtil.validateLength(category.getName(), 100) && !(category.getName().isEmpty())) {
			throw new CategoryNameException("Category name must be between 1 and 100 characters");
		} else if (ValidationUtil.validateLength(category.getDescription(), 100)
				&& !(category.getDescription().isEmpty())) {
			throw new CategoryDescriptionException("Category description must be between 1 and 100 characters");
		} else {
			categoryDAO.update(category);
		}
	}

	@Override
	public void removeCategory(Category category) {
		categoryDAO.delete(category);

	}

	@Override
	public Category getCategory(int categoryId) {
		Category category = categoryDAO.find(categoryId);
		return category;

	}
	
	@Override
	public List<Category> getTMCategories(int managerUserId) {
		List<Category>categories = categoryDAO.findAll(managerUserId);
		return categories;
		
	}
	@Override
	public void approveCategory(int categoryId) {
		Category category = categoryDAO.find(categoryId);
		category.setPermission_status(APPROVED);
		categoryDAO.update(category);
		
	}
	
	
	@Override
	public int getUserId(int categoryId) {
			Category category = categoryDAO.find(categoryId);
					return category.getUserId();
			}
		
	@Override
	public void rejectCategory(int categoryId, String rejectionMessage) {
		Category category = categoryDAO.find(categoryId);
		category.setRejectionMessage(rejectionMessage);
		category.setPermission_status(REJECT);
		categoryDAO.update(category);
		
	}

}
