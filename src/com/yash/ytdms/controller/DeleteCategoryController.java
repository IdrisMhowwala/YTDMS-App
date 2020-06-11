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
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.service.NotificationService;

/**
 * Servlet implementation class DeleteCategoryController
 */
@WebServlet(value = "/delete", initParams = { @WebInitParam(name = "n_operation_type", value = NotificationService.DELETE_OPERATION_TYPE+""),
		@WebInitParam(name = "n_item_type", value = "1") })
public class DeleteCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = LogManager.getLogger(DeleteCategoryController.class);
	CategoryService categoryService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCategoryController() {
		super();
		categoryService = (CategoryService) ObjectFactory.getObject(CategoryService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{

			Category category = categoryService.getCategory(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("categoryName", category.getName());
			request.setAttribute("categoryId", category.getId());
			request.setAttribute("n_operation_type", getServletConfig().getInitParameter("n_operation_type"));
			request.setAttribute("n_item_type", getServletConfig().getInitParameter("n_item_type"));
			categoryService.removeCategory(category);
			request.getRequestDispatcher("/NotificationPreparationController").forward(request, response);
		}

	}

}
