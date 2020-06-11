package com.yash.ytdms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Category;
import com.yash.ytdms.exception.CategoryDescriptionException;
import com.yash.ytdms.exception.CategoryNameException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.service.NotificationService;

/**
 * Servlet implementation class CategoryValidationController
 */
@WebServlet(value="/AddCategoryController",initParams= {
		@WebInitParam(name="n_operation_type", value=NotificationService.ADD_OPERATION_TYPE+""),
		@WebInitParam(name="n_item_type", value="1")
})
public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = LogManager.getLogger(AddCategoryController.class);
	private CategoryService categoryService = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategoryController() {
		super();
		categoryService = (CategoryService) ObjectFactory.getObject(CategoryService.class);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = (Category) ObjectFactory.getObject(Category.class);
		category.setName(request.getParameter("name"));
		category.setDescription(request.getParameter("description"));
		category.setUserId(2);
		 
		try {
			int categoryId =categoryService.createCategory(category);
			request.setAttribute("categoryId", categoryId);
			request.setAttribute("n_operation_type", getServletConfig().getInitParameter("n_operation_type"));
			request.setAttribute("n_item_type", getServletConfig().getInitParameter("n_item_type"));
			request.getRequestDispatcher("/NotificationPreparationController").forward(request, response);
		}catch (CategoryNameException e) {
			response.sendRedirect("add-category.jsp?nameErrMsg="+e.getMessage());
		}catch (CategoryDescriptionException e) {
			response.sendRedirect("add-category.jsp?descErrMsg="+e.getMessage());
		}
		
	}

}
