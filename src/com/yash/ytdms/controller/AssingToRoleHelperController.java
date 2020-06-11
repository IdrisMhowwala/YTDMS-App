package com.yash.ytdms.controller;
/**
 * This servlet is used to assign the permissions by selecting specified roles
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ytdms.domain.Permission;
import com.yash.ytdms.domain.PermissionModule;
import com.yash.ytdms.domain.Role;

@WebServlet("/AssingToRoleHelperController")
public class AssingToRoleHelperController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PermissionModule> permissionModules = null;
		Integer roleId = null;
		if (request.getParameter("role") != null) {
			roleId = Integer.parseInt(request.getParameter("role"));
			int moduleId = Integer.parseInt(request.getParameter("moduleId"));
			String assignedPermissions[] = request.getParameterValues("permission");
			permissionModules = checkAssignedPermission(permissionModules, moduleId, assignedPermissions);
		}
		Role role = new Role();
		role.setId(roleId);
		role.setPermissionModules(permissionModules);
		request.setAttribute("role", role);
	}

	private List<PermissionModule> checkAssignedPermission(List<PermissionModule> permissionModules, int moduleId,
			String[] assignedPermissions) {
		List<Permission> permissions;
		if (assignedPermissions != null) {
			permissionModules = new ArrayList<>();
			permissions = new ArrayList<>();
			Permission permission;
			for (String currentPermission : assignedPermissions) {
				permission = new Permission();
				permission.setId(Integer.parseInt(currentPermission));
				permissions.add(permission);
			}
			PermissionModule permissionModule = new PermissionModule();
			permissionModule.setId(moduleId);
			permissionModule.setPermissions(permissions);
			permissionModules.add(permissionModule);
		}
		return permissionModules;
	}
}
