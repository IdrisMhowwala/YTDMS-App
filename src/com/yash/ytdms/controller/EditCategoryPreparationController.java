package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Category;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.serviceimpl.CategoryServiceImpl;

/**
 * Servlet implementation class EditCategoryPreparationController
 */
@WebServlet("/edit")
public class EditCategoryPreparationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(EditCategoryPreparationController.class);
	CategoryService categoryService; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoryPreparationController() {
        super();
        categoryService = (CategoryService) ObjectFactory.getObject(CategoryService.class);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * model preparation
		 * taking data from UI,prepare model,call service,redirect on view.
		 */
		HttpSession session=request.getSession();
		int categoryId=Integer.parseInt(request.getParameter("id"));
		session.setAttribute("categoryId",categoryId);
		Category category = categoryService.getCategory(categoryId);
		request.setAttribute("categoryName", category.getName());
		request.setAttribute("categoryDescription", category.getDescription());
		
		request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
		
		
	}

}
