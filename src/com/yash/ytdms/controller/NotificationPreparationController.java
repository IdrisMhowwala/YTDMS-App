package com.yash.ytdms.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Category;
import com.yash.ytdms.domain.Notification;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.service.NotificationService;

/**
 * Servlet implementation class NotificationPreparationController
 */
@WebServlet("/NotificationPreparationController")
public class NotificationPreparationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = LogManager.getLogger(NotificationPreparationController.class);
	private NotificationService notificationService;
	private CategoryService categoryService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NotificationPreparationController() {
		notificationService = (NotificationService) ObjectFactory.getObject(NotificationService.class);
		categoryService = (CategoryService) ObjectFactory.getObject(CategoryService.class);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* notification preparation */

		Notification notification = new Notification();
		int categoryId = (int) request.getAttribute("categoryId");
		Category category = categoryService.getCategory(categoryId);

		int n_operation_type = Integer.parseInt((String) request.getAttribute("n_operation_type"));
		int n_item_type = Integer.parseInt((String) request.getAttribute("n_item_type"));

		if (n_item_type == NotificationService.CATEGORY_ITEM_TYPE) {
			if(n_operation_type==NotificationService.ADD_OPERATION_TYPE) {
				notification.setMessage("Category " + category.getName() +  " was " + " added sucessfully");				
			}else if(n_operation_type==NotificationService.UPDATE_OPERATION_TYPE) {
				notification.setMessage("Category " + category.getName() +  " was " + " edited sucessfully");
			}else  {
				notification.setMessage("Category " + request.getAttribute("categoryName") +  " was " + " deleted sucessfully");
			}
			notification.setGeneratedBy(1);//TODO take loggedInUserId from session
			notification.setSentTo(4);//TODO take loggedInMgrId from session
			notification.setSentDate(new Date(System.currentTimeMillis()));
			notification.setN_operation_type(n_operation_type);
			notification.setN_item_type(n_item_type);
			notification.setN_item_id(categoryId);
			notificationService.createNotification(notification);
			request.getRequestDispatcher("/CategoryListingController").forward(request, response);

		} else if (n_item_type == 2) {

			// TODO Section notification management

		} else if (n_item_type == 3) {

			// TODO Document notification management

		} else {

			// TODO Group notification management
		}

	}

}
