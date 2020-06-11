package com.yash.ytdms.controller;
/**
 * This servlet lets us to add permissions according to specified permission group
 * 
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.ytdms.domain.Permission;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.PermissionService;

/**
 * Servlet implementation class AddPermissionController
 */
@WebServlet("/AddPermissionController")
public class AddPermissionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PermissionService permissionService=null;  
    Permission permission=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPermissionController() {
        super();
        permissionService=(PermissionService) ObjectFactory.getObject(PermissionService.class);
       
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int moduleId=Integer.parseInt(request.getParameter("moduleId"));
		System.out.println("I am here with module id:"+moduleId);
		HttpSession session=request.getSession();
		String moduleName=request.getParameter("name");
		System.out.println(moduleName);
		permission=new Permission();
		permission.setModuleId(moduleId);
		permission.setName(moduleName);
		
		permissionService.addPermission(permission);
		session.setAttribute("moduleId", moduleId);
		//response.sendRedirect("PermissionPreparationController");
		getServletContext().getRequestDispatcher("/PermissionPreparationController").forward(request, response);

	}

}
