package com.yash.ytdms.controller;
/**
 * this servlet is used to assign permissions according to role by calling its helper controller
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Role;
import com.yash.ytdms.exception.RoleException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.RoleService;

/**
 * Servlet implementation class PermissionsDisplayController
 */
@WebServlet("/PermissionsAssignController")
public class PermissionsAssignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService;
	static final Logger LOGGER = Logger.getLogger(PermissionsAssignController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PermissionsAssignController() {
		super();
		roleService = (RoleService) ObjectFactory.getObject(RoleService.class);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/AssingToRoleHelperController").include(request, response);
		Role role = (Role) request.getAttribute("role");
		roleCheck(request, response, role);
	}

	private void roleCheck(HttpServletRequest request, HttpServletResponse response, Role role)
			throws ServletException, IOException {
		try {
			role = roleService.assignPermissionsToRole(role);
			request.setAttribute("role", role);
			getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

		} catch (RoleException e) {
			request.setAttribute("msg", e.getMessage());
			getServletContext().getRequestDispatcher("/ModuleController").forward(request, response);
		}
	}

}
