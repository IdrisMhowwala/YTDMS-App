package com.yash.ytdms.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.GroupService;


/**
 * Servlet implementation class CreateGeneralGroup
 */
@WebServlet("/CreateGeneralGroup")
public class CreateGeneralGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GroupService groupService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGeneralGroup() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		groupService=(GroupService) ObjectFactory.getObject(GroupService.class);
		groupService.createGeneralGroup();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("groupHome.jsp");
	}

}
