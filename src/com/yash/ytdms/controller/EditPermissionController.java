package com.yash.ytdms.controller;
/**
 * This servlet is used to edit permissions name
 * This servlet is used to retrieve all the information of permission which is to be updated
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
 * Servlet implementation class EditPermissionController
 */
@WebServlet("/EditPermissionController")
public class EditPermissionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PermissionService permissionService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPermissionController() {
        super();
        permissionService=(PermissionService) ObjectFactory.getObject(PermissionService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int permissionId=Integer.parseInt(request.getParameter("id"));
		HttpSession session=request.getSession();
		
		Permission permission=permissionService.getPermission(permissionId);
		session.setAttribute("permissionName",permission.getName());
		session.setAttribute("moduleId",permission.getModuleId());
		session.setAttribute("permissionId", permissionId);
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/edit_permission.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
