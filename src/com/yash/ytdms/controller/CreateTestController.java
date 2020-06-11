package com.yash.ytdms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Test;
import com.yash.ytdms.exception.TestException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.TestService;
import com.yash.ytdms.serviceimpl.TestServiceImpl;

/**
 * Servlet implementation class CreateTestController
 */
@WebServlet("/CreateTestController")
public class CreateTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TestService testService=null;
	static final Logger LOGGER = Logger.getLogger(CreateTestController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTestController() {
        super();
        testService = (TestService) ObjectFactory.getObject(TestService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test test = new Test();
		test.setName(request.getParameter("name"));
		try {
			testService.createTest(test);
			LOGGER.info("test created successully");
			response.sendRedirect("welcome.jsp?msg=Test Added!");
		}
		catch (TestException e) {
			response.sendRedirect("addTest.jsp?msg="+e.getMessage());
		}
	}

}
