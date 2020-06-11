package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.ytdms.domain.Notification;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.service.NotificationService;
import com.yash.ytdms.serviceimpl.NotificationServiceImpl;

/**
 * Servlet implementation class ListNotificationController
 */
@WebServlet("/ListNotificationController")
public class ListNotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NotificationService notificationService=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNotificationController() {
        super();
        notificationService = (NotificationService) ObjectFactory.getObject(NotificationService.class);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("Id="+userId);
		List<Notification> notifications =notificationService.getAllNotifications(userId);
		System.out.println(notifications.size());
//		for (Notification notification : notifications) {
//			System.out.println(notification.getMessage());
//		}
		HttpSession session = request.getSession();
		session.setAttribute("notifications", notifications);
		response.sendRedirect("notifications.jsp");
	}

}
