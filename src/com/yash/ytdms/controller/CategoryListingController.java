package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Category;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.CategoryService;

@WebServlet("/CategoryListingController")
public class CategoryListingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = LogManager.getLogger(CategoryListingController.class);
	private CategoryService categoryService;

	public CategoryListingController() {
		super();
		categoryService = (CategoryService) ObjectFactory.getObject(CategoryService.class);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categories = categoryService.listCategories();
		HttpSession session = request.getSession();
		session.setAttribute("categories", categories);
		response.sendRedirect("categoryListForm.jsp");

	}

}
