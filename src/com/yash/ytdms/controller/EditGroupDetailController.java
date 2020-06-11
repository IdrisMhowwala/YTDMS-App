package com.yash.ytdms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.yash.ytdms.domain.Group;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.GroupService;

/**
 * Servlet implementation class EditGroupDetailController 
 * This Servlet will Edit the List of groups on the basis of userId
 */
@WebServlet("/EditGroupDetailController")
public class EditGroupDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GroupService groupService = null;
	static final Logger LOGGER = Logger.getLogger(EditGroupDetailController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditGroupDetailController() {
		super();
		groupService = (GroupService) ObjectFactory.getObject(GroupService.class);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Group group = new Group();
		group.setName(request.getParameter("name"));
		group.setDescription(request.getParameter("description"));
		
		if(request.getParameter("description").length()<=255) {
			int userId = 101;
		group.setId(Integer.parseInt(request.getParameter("id")));
		group.setUserId(userId);
		groupService.editGroup(group);
		LOGGER.info("Group Edited successully");
		getServletContext().getRequestDispatcher("/ShowTrainerGroupController").forward(request, response);
		}
		else 
			
		{
			
			request.setAttribute(" ", "description");
			response.sendRedirect("editGroupDetail.jsp?errMsg=Max Length of description is 255 characters");
		}

	}

}
