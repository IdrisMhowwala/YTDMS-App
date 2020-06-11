package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class PermissionPreparationController
 */
@WebServlet("/PermissionPreparationController")
public class PermissionPreparationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       PermissionService permissionService=null;
       PermissionModuleService permissionModuleService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PermissionPreparationController() {
        super();
       permissionService=(PermissionService) ObjectFactory.getObject(PermissionService.class);
       permissionModuleService=(PermissionModuleService)ObjectFactory.getObject(PermissionModuleService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		int groupId=(int) httpSession.getAttribute("moduleId");
		System.out.println("GID:"+groupId);
		
		List<Permission> permissionList= permissionService.getPermissionService(groupId);
		for(Permission permission:permissionList)
		{
			System.out.println("printing list:"+permission.getName());
		}
		request.setAttribute("permissionList", permissionList);
		PermissionModule permissionModule=permissionModuleService.getGroup(groupId);
		
	

		
	String name=permissionModule.getName();
	String description=permissionModule.getDescription();
	//int groupid=permissionModule.getId();
		request.setAttribute("groupNames",name);
		request.setAttribute("groupDescription", description);
		
		getServletContext().getRequestDispatcher("/module_permission.jsp").forward(request, response);;
		
	}

}
