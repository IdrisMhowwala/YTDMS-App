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
import com.yash.ytdms.daoimpl.GroupDAOImpl;
import com.yash.ytdms.domain.Group;
import com.yash.ytdms.exception.GroupStatusException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.GroupService;
import com.yash.ytdms.serviceimpl.GroupServiceImpl;

/**
 * Servlet implementation class StatusController
 */
@WebServlet("/StatusController")
public class StatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 GroupService groupService;
     GroupDAO groupDAO;
     Group group;
     private int role=1;
     static final Logger LOGGER = Logger.getLogger(ShowAllGroupController.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusController() {
        super();
        // TODO Auto-generated constructor stub
        groupService = (GroupService) ObjectFactory.getObject(GroupService.class);
        groupDAO = (GroupDAO) ObjectFactory.getObject(GroupDAO.class);
        group = new Group();
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session=request.getSession();
		 int loggedInUserId = Integer.parseInt(request.getParameter("id"));
		 int loggedInUserStatus = Integer.parseInt(request.getParameter("status"));
		 try {
			groupService.changeStatus(loggedInUserStatus,loggedInUserId);
		} catch (GroupStatusException e) {
			e.printStackTrace();
		}
		
		 List<Group> groups = groupService.listGroups(role);
		 LOGGER.info("Manager-Group List Extracted successully");
         session.setAttribute("groups", groups);
         response.sendRedirect("manager-dashboard.jsp");
		 
	}

}
