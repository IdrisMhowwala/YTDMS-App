package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class PermissionController
 */
@WebServlet("/PermissionController")
public class PermissionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PermissionService permissionService=null;  
    PermissionModuleService permissionModuleService=null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PermissionController() {
        super();
        permissionService=(PermissionService) ObjectFactory.getObject(PermissionService.class);
        permissionModuleService=(PermissionModuleService) ObjectFactory.getObject(PermissionModuleService.class);
        
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int groupId=Integer.parseInt(request.getParameter("id"));
		
		List<Permission> permissionList= permissionService.getPermissionService(groupId);
		List<Integer> permissionsId=new ArrayList<Integer>();
		
		for(Permission permission:permissionList) {
			int permissionId=permission.getId();
			permissionsId.add(permissionId);
		}
		PermissionModule permissionModule=permissionModuleService.getGroup(groupId);
		
		String name=permissionModule.getName();
		String description=permissionModule.getDescription();
		//int groupid=permissionModule.getId();
		request.setAttribute("permissionList",permissionList);
		request.setAttribute("groupNames",name);
		request.setAttribute("groupDescription", description);
		session.setAttribute("groupId",groupId);
		request.setAttribute("permissionsId", permissionsId);
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/module_permission.jsp");
		requestDispatcher.forward(request, response);
	}

}
