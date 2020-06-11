package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ytdms.service.GroupService;
import com.yash.ytdms.serviceimpl.GroupServiceImpl;

/**
 * Servlet implementation class UpdateGroupController
 */
@WebServlet("/UpdateGroupController")
public class UpdateGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GroupService groupService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGroupController() {
        super();
        groupService=new GroupServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idOfGroup=Integer.parseInt(request.getParameter("idOfGroup"));
		int idOfTrainee=Integer.parseInt(request.getParameter("idOfTrainee"));
		groupService.updateGroup(idOfGroup, idOfTrainee);
		response.sendRedirect("all-group.jsp");
		
	}


}
