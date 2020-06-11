package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.serviceimpl.CategoryServiceImpl;

/**
 * Servlet implementation class ApproveCategoryController
 */
@WebServlet("/ApproveCategoryController")
public class ApproveCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService categoryService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveCategoryController() {
        super();
        categoryService = new CategoryServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		categoryService.approveCategory(categoryId);
		response.sendRedirect("TMCategoryPreparationController");
	}

}
