package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.ytdms.domain.Group;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.GroupService;


/**
 * Servlet implementation class ShowTrainerGroupController This Servlet will
 * Show the List of groups on the basis of userId
 */
@WebServlet("/ShowTrainerGroupController")
public class ShowTrainerGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GroupService groupService = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowTrainerGroupController() {
		super();
		groupService = (GroupService) ObjectFactory.getObject(GroupService.class);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = 1;
		List<Group> groups = groupService.listGroup(userId);
		session.setAttribute("groups", groups);
		response.sendRedirect("my-group.jsp");
	}

}
