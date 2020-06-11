package com.yash.ytdms.controller;
/**
 * This servlet lets you to add modules in app
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.PermissionModule;
import com.yash.ytdms.domain.Role;
import com.yash.ytdms.exception.PermissionException;
import com.yash.ytdms.exception.RoleException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.PermissionModuleService;
import com.yash.ytdms.service.RoleService;

/**
 * Servlet implementation class AddRoleController
 */
@WebServlet("/AddModuleController")
public class AddModuleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PermissionModuleService permissionModuleService=null;
	static final Logger LOGGER = Logger.getLogger(AddModuleController.class);      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddModuleController() {
        super();
        permissionModuleService=(PermissionModuleService) ObjectFactory.getObject(PermissionModuleService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PermissionModule module = new PermissionModule();
		
		try {
			module.setName(request.getParameter("name"));
			module.setDescription(request.getParameter("description"));
			permissionModuleService.addModule(module);
			response.sendRedirect("index.jsp");
		} catch (PermissionException e) {
			response.sendRedirect("addModule.jsp?msg="+ e.getMessage());
		}
	}

}
