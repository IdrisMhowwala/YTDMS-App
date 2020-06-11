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
 * Servlet implementation class RejectCategoryController
 */
@WebServlet("/RejectCategoryController")
public class RejectCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService categoryService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectCategoryController() {
        super();
         categoryService= new CategoryServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		String rejectionMessage=(String) request.getParameter("rejectionMessage");
		System.out.println("id:"+categoryId+"rejMsg="+rejectionMessage);
		categoryService.rejectCategory(categoryId,rejectionMessage);
		response.sendRedirect("TMCategoryPreparationController");
		
		
	
	}

}
