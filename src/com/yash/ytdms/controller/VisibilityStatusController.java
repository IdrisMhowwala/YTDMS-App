package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.serviceimpl.CategoryServiceImpl;

/**
 * Servlet implementation class PermissionVisibilityController
 */
@WebServlet("/VisibilityStatusController")
public class VisibilityStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(VisibilityStatusController.class);
	private CategoryService categoryService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisibilityStatusController() {
        super();
        categoryService=new CategoryServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 HttpSession session =request.getSession();
	 int categoryId = Integer.parseInt(request.getParameter("id"));
	 int categoryVisibilityStatus = Integer.parseInt(request.getParameter("visibilityStatus"));
	 categoryService.changeVisbilityStatus(categoryId, categoryVisibilityStatus);
	 response.sendRedirect("CategoryListingController");
	 
						 
	}

}
