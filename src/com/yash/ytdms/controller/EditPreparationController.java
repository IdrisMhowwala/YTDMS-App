package com.yash.ytdms.controller;
/**
 * This servlet edits the permission data.
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
 * Servlet implementation class EditPreparationController
 */
@WebServlet("/EditPreparationController")
public class EditPreparationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PermissionService permissionService=null;  
	PermissionModuleService permissionModuleService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPreparationController() {
        super();
        permissionService=(PermissionService) ObjectFactory.getObject(PermissionService.class);
        permissionModuleService=(PermissionModuleService) ObjectFactory.getObject(PermissionModuleService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		Permission permission=new Permission();
		int permissionId=(int)session.getAttribute("permissionId");
		String permissionName=request.getParameter("name");
		
		int groupId=(int)session.getAttribute("moduleId");
		PermissionModule permissionModule=permissionModuleService.getGroup(groupId);
		String groupName=permissionModule.getName();
		String groupDescription=permissionModule.getDescription();
		request.setAttribute("groupNames",groupName);
		request.setAttribute("groupDescription",groupDescription);
		permission.setName(permissionName);
		permission.setModuleId(groupId);
		permission.setId(permissionId);
		permissionService.editPermission(permission);
		List<Permission> permissionList=permissionService.getPermissionService(groupId);
		
		request.setAttribute("permissionList",permissionList);
		RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/module_permission.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}
