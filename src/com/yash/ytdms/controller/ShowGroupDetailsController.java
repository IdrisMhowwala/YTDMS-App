package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.dao.GroupDAO;
import com.yash.ytdms.domain.Group;
import com.yash.ytdms.domain.User;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.GroupService;

/**
 * Servlet implementation class ShowGroupDetailsController
 */
@WebServlet("/ShowGroupDetailsController")
public class ShowGroupDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int role=2;
	static final Logger LOGGER = Logger.getLogger(ShowTraineeListController.class);
	GroupDAO groupDAO;
	GroupService groupService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowGroupDetailsController() {
		super();
		groupDAO = (GroupDAO) ObjectFactory.getObject(GroupDAO.class);
        groupService  =(GroupService) ObjectFactory.getObject(GroupService.class);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Group> groups = groupService.listGroup(Integer.parseInt(request.getParameter("id")));
		LOGGER.info("Trainee List Extracted successully");
		session.setAttribute("group", groups);
		session.setAttribute("idOfAccordian2", request.getParameter("id"));
		response.sendRedirect("my-group.jsp");
	}
}
