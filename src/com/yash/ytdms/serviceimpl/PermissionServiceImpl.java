package com.yash.ytdms.serviceimpl;

import java.util.List;

import com.yash.ytdms.dao.PermissionDAO;
import com.yash.ytdms.domain.Permission;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {

	private PermissionDAO permissionDAO;

	public PermissionServiceImpl() {
		permissionDAO = (PermissionDAO) ObjectFactory.getObject(PermissionDAO.class);
	}

	@Override
	public List<Permission> permissionsByRole(int moduleId) {
		List<Permission> permissions = permissionDAO.permissionsByRole(moduleId);
		return permissions;
	}

	@Override
	public List<Permission> getPermissionService(int groupId) {

		List<Permission> modulePermission=permissionDAO.list(groupId);
		return modulePermission;
	}

	@Override
	public String getGroupName(int groupId) {
		String getGroup=permissionDAO.get(groupId);
		return getGroup;
	}

	@Override
	public void addPermission(Permission permission) {
		permissionDAO.insert(permission);
		
	}

	@Override
	public Permission getPermission(int permissionId) {
		Permission permission=permissionDAO.getAll(permissionId);
		return permission;
	}

	@Override
	public void editPermission(Permission permissionName) {
		permissionDAO.update(permissionName);
		
	}

	@Override
	public void remove(int permissionId) {
		permissionDAO.delete(permissionId);
		
	}

}
