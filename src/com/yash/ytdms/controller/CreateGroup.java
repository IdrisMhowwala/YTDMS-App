package com.yash.ytdms.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yash.ytdms.dao.GroupDAO;
import com.yash.ytdms.daoimpl.GroupDAOImpl;
import com.yash.ytdms.domain.Group;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.GroupService;
import com.yash.ytdms.serviceimpl.GroupServiceImpl;

/**
 * Servlet implementation class CreateGroup
 */
@WebServlet("/CreateGroup")
public class CreateGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GroupDAO groupDAO;
    GroupService groupService;
    static final Logger LOGGER = Logger.getLogger(CreateTestController.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
    	super.init();
    	groupService=(GroupService) ObjectFactory.getObject(GroupService.class);
		groupService.createGeneralGroup();
    	
    }
    public CreateGroup() {
        super();
        groupDAO=(GroupDAO) ObjectFactory.getObject(GroupDAO.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Group group=new Group();
		group.setName(request.getParameter("name"));
		group.setDescription(request.getParameter("description"));
		group.setStatus(Integer.parseInt(request.getParameter("status")));
		group.setUserId(1);
		LOGGER.info("Values fetched from form successfully!");
		try {
			group.setStart_date(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("start_date")));
			group.setEnd_date(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("end_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		groupDAO.insert(group);
		LOGGER.info("Group inserted successfully!");
		getServletContext().getRequestDispatcher("/createGroup.jsp?successMsg=Group Created Successfully !").forward(request, response);
	}

}
