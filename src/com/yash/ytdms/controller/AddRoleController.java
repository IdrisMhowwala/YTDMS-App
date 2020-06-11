package com.yash.ytdms.controller;
/**
 * This servlet lets us to add roles.
 * According to these roles only specified permissions are being shown
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
 * Servlet implementation class AddRoleController
 */
@WebServlet("/AddRoleController")
public class AddRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService=null;
	static final Logger LOGGER = Logger.getLogger(AddRoleController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoleController() {
        super();
        roleService=(RoleService) ObjectFactory.getObject(RoleService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Role role=new Role();
		
	
			role.setName(request.getParameter("RoleName"));
			roleService.addRole(role);
			String msg="Role Has been Added Successfully!";
			response.sendRedirect("addRole.jsp?msg="+msg);
	}

}
