package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Permission;
import com.yash.ytdms.domain.Role;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.PermissionService;
import com.yash.ytdms.service.RoleService;

/**
 * Servlet implementation class ModuleController
 */
@WebServlet("/ModuleController")
public class ModuleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PermissionService permissionService;
	private RoleService roleService = null;
	static final Logger LOGGER = Logger.getLogger(ModuleController.class);

	public ModuleController() {
		super();
		roleService = (RoleService) ObjectFactory.getObject(RoleService.class);
		permissionService = (PermissionService) ObjectFactory.getObject(PermissionService.class);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int moduleId = Integer.parseInt(request.getParameter("moduleId"));
		request.setAttribute("moduleId", moduleId);
		List<Role> roles = roleService.listRoles();
		request.setAttribute("roles", roles);
		List<Permission> permissions = permissionService.permissionsByRole(moduleId);
		request.setAttribute("permissions", permissions);
		String msg = (String) request.getAttribute("msg");
		if (msg == null)
			msg = " ";
		getServletContext().getRequestDispatcher("/selectRole.jsp?msg=" + msg).forward(request, response);

	}
}