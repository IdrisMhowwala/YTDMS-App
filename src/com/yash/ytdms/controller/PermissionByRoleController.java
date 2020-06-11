package com.yash.ytdms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Role;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.RoleService;

/**
 * Servlet implementation class ListRolePermissionController
 */
@WebServlet("/PermissionByRoleController")
public class PermissionByRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService = null;
	static final Logger LOGGER = Logger.getLogger(PermissionByRoleController.class);

	public PermissionByRoleController() {
		super();
		roleService = (RoleService) ObjectFactory.getObject(RoleService.class);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		int roleId=Integer.parseInt(request.getParameter("roleId"));

		Role roles=roleService.getRoleById(roleId);
		session.setAttribute("roles", roles);
		LOGGER.info("list role successully selected");
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/listPermission.jsp");
		requestDispatcher.forward(request, response);

	}

}
