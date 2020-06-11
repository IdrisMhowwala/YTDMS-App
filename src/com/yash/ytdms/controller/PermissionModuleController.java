package com.yash.ytdms.controller;

/**
 * This class is used to show all the modules name along with description present in this app
 * If there are no modules present then msg would be shown of no modules present
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.ytdms.domain.PermissionModule;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.PermissionModuleService;

/**
 * Servlet implementation class PermissionModuleController
 */
@WebServlet("/PermissionModuleController")
public class PermissionModuleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PermissionModuleService permissionModuleService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PermissionModuleController() {
        super();
        permissionModuleService=(PermissionModuleService) ObjectFactory.getObject(PermissionModuleService.class);
    }

	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PermissionModule> listGroup = permissionModuleService.getGroupList();
		if(listGroup!=null)
		{
			request.setAttribute("listGroupNames", listGroup);
		}
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/superuser_dashboard.jsp");
		requestDispatcher.forward(request, response);
	}

}
