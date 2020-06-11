package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.yash.ytdms.domain.Role;
import com.yash.ytdms.exception.RoleException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.RoleService;

/**
 * Servlet implementation class AddRoleController
 */
@WebServlet("/ListRoleController")
public class ListRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService = null;
	static final Logger LOGGER = Logger.getLogger(ListRoleController.class);

	public ListRoleController() {
		super();
		/*roleService = new RoleServiceImpl(); */
		roleService = (RoleService) ObjectFactory.getObject(RoleService.class);
		System.out.println(roleService);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Role> roles = null;
		roles = roleService.listRoles();
		
		session.setAttribute("roles", roles);
		LOGGER.info("list role successully selected");
		response.sendRedirect("listRole.jsp?msg=list role successully selected!");

	}

}
