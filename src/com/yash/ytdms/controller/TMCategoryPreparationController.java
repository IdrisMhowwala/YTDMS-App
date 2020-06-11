package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.yash.ytdms.domain.Category;
import com.yash.ytdms.service.CategoryService;

import com.yash.ytdms.serviceimpl.CategoryServiceImpl;


/**
 * Servlet implementation class TMCategoryPreparationController
 */
@WebServlet("/TMCategoryPreparationController")
public class TMCategoryPreparationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService categoryService= null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TMCategoryPreparationController() {
        super();
        categoryService = new CategoryServiceImpl();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int managerUserId=4;
		List<Category> categories = categoryService.getTMCategories(managerUserId);
		HttpSession session = request.getSession();
		session.setAttribute("tmCategories", categories);
		response.sendRedirect("tm-categorylist.jsp");
		
	}

}
