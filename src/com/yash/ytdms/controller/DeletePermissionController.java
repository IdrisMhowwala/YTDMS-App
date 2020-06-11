package com.yash.ytdms.controller;
/**
 * This servlet is used to delete the permissions of specified module.
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

import com.yash.ytdms.domain.Permission;
import com.yash.ytdms.domain.PermissionModule;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.PermissionModuleService;
import com.yash.ytdms.service.PermissionService;

/**
 * Servlet implementation class DeletePermissionController
 */
@WebServlet("/DeletePermissionController")
public class DeletePermissionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PermissionService permissionService=null;
    PermissionModuleService permissionModuleService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePermissionController() {
        super();
       permissionService=(PermissionService) ObjectFactory.getObject(PermissionService.class);
       permissionModuleService=(PermissionModuleService) ObjectFactory.getObject(PermissionModuleService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int permissionsId=Integer.parseInt(request.getParameter("id"));
		permissionService.remove(permissionsId);
		System.out.println("Rajpal is Rajpal"+session.getAttribute("moduleId"));
		int groupId=(int)session.getAttribute("moduleId");
		List<Permission> permissionList=permissionService.getPermissionService(groupId);
		PermissionModule permissionModule=permissionModuleService.getGroup(groupId);
		String groupName=permissionModule.getName();
		String groupDescription=permissionModule.getDescription();
		request.setAttribute("groupNames",groupName);
		request.setAttribute("groupDescription",groupDescription);
		session.setAttribute("groupId",groupId);
		request.setAttribute("permissionsId", permissionsId);
		
		request.setAttribute("permissionList",permissionList);
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/module_permission.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}
