package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import com.yash.ytdms.domain.User;

import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.GroupService;
import com.yash.ytdms.serviceimpl.GroupServiceImpl;



/**
 * Servlet implementation class ShowTraineeListController
 */
@WebServlet("/ShowTraineeListController")
public class ShowTraineeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int role=2;
	static final Logger LOGGER = Logger.getLogger(ShowTraineeListController.class);
	GroupDAO groupDAO;
	GroupService groupService;
	
       
  
    public ShowTraineeListController() {
        super();
     
		groupDAO = (GroupDAO) ObjectFactory.getObject(GroupDAO.class);
        groupService  =(GroupService) ObjectFactory.getObject(GroupService.class);
   
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<User> users= groupDAO.findById(Integer.parseInt(request.getParameter("id")));
		LOGGER.info("Trainee List Extracted successully");
		List<Group> groups = groupService.listGroups(role);
		session.setAttribute("user", users);
		session.setAttribute("groupId", Integer.parseInt(request.getParameter("id")));
		session.setAttribute("names", request.getParameter("name"));	
		session.setAttribute("idOfAccordian", request.getParameter("id"));
		if(role==1) {
			response.sendRedirect("manager-dashboard.jsp");
		}
		else if(role==2){
			response.sendRedirect("all-group.jsp");
		}
		else {
			response.sendRedirect("trainee-dashboard.jsp");
		}

	}

}
