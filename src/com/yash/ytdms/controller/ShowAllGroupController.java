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

import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.GroupService;
import com.yash.ytdms.serviceimpl.GroupServiceImpl;

/**
 * Servlet implementation class ShowAllGroupController
 */
@WebServlet("/ShowAllGroupController")
public class ShowAllGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int role = 1;
	static final Logger LOGGER = Logger.getLogger(ShowAllGroupController.class);
	GroupDAO groupDAO;
	GroupService groupService;

	public ShowAllGroupController() {
		super();

		groupDAO = (GroupDAO) ObjectFactory.getObject(GroupDAO.class);
		groupService = (GroupService) ObjectFactory.getObject(GroupService.class);

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<Group> groups = groupService.listGroups(role);
		LOGGER.info("Group List Extracted successully");
		session.setAttribute("groups", groups);
		if(role==2)
			response.sendRedirect("all-group.jsp");
		else if(role==1)
			response.sendRedirect("manager-dashboard.jsp");
		else
			response.sendRedirect("groupHome.jsp");
	}

}
