package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Category;
import com.yash.ytdms.exception.CategoryDescriptionException;
import com.yash.ytdms.exception.CategoryNameException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.service.NotificationService;
import com.yash.ytdms.service.TestService;
import com.yash.ytdms.serviceimpl.CategoryServiceImpl;

/**
 * Servlet implementation class EditCategoryController
 */
@WebServlet(value="/EditCategoryController",initParams= {
		@WebInitParam(name="n_item_type", value="1" ),
		@WebInitParam(name="n_operation_type", value=NotificationService.UPDATE_OPERATION_TYPE+""),
})
public class EditCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(EditCategoryController.class);
	CategoryService categoryService; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoryController() {
        super();
        
        categoryService = (CategoryService) ObjectFactory.getObject(CategoryService.class);
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * model preparation
		 * taking data from UI,prepare model,call service,redirect on view.
		 */
		HttpSession session = request.getSession();
		Category category= categoryService.getCategory((int) (session.getAttribute("categoryId")));
		category.setName(request.getParameter("name"));
		category.setDescription(request.getParameter("description"));
		
		try {
			request.setAttribute("categoryId", session.getAttribute("categoryId"));
			request.setAttribute("n_operation_type", getServletConfig().getInitParameter("n_operation_type"));
			request.setAttribute("n_item_type", getServletConfig().getInitParameter("n_item_type"));
			categoryService.addUpdatedCategory(category);
			request.getRequestDispatcher("/NotificationPreparationController").forward(request, response);
		}catch (CategoryNameException e) {
			response.sendRedirect("updateCategory.jsp?nameErrMsg="+e.getMessage());
		}catch (CategoryDescriptionException e) {
			response.sendRedirect("updateCategory.jsp?descErrMsg="+e.getMessage());
		}
		
	}

}
