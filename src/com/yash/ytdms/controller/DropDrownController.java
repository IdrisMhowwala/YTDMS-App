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
import com.yash.ytdms.service.TestService;

/**
 * Servlet implementation class DropDrownController
 */
@WebServlet("/DropDrownController")
public class DropDrownController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	

	GroupService groupService;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropDrownController() {
        super();
     
        groupService = (GroupService) ObjectFactory.getObject(GroupService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int role=3;
		List<Group> groups = groupService.listGroups(role);
		
		session.setAttribute("groups", groups);
		response.sendRedirect("user-registration.jsp");
	}

}
