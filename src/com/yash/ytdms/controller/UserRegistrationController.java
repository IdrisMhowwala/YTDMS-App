package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.UserException;

import com.sun.media.jfxmedia.logging.Logger;
import com.yash.ytdms.domain.User;
import com.yash.ytdms.service.UserService;
import com.yash.ytdms.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class UserRegistrationController
 */
@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public UserRegistrationController() {
		super();
		userService = new UserServiceImpl();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		//user.setRole(3);
		user.setGroupDropDown(Integer.parseInt(request.getParameter("groupId")));

		try {
			userService.registerUser(user);

		} catch (UserException e1) {

			e1.printStackTrace();
		}

		response.sendRedirect("home.jsp");
	}

}
