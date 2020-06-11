package com.yash.ytdms.serviceimpl;

import java.util.List;

import com.yash.ytdms.dao.PermissionModuleDAO;
import com.yash.ytdms.domain.PermissionModule;
import com.yash.ytdms.exception.PermissionException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.PermissionModuleService;

public class PermissionModuleServiceImpl implements PermissionModuleService {
	private PermissionModuleDAO permissionModuleDAO;

	public PermissionModuleServiceImpl() {
		permissionModuleDAO = (PermissionModuleDAO) ObjectFactory.getObject(PermissionModuleDAO.class);
	}

	@Override
	public List<PermissionModule> listAll() {
		List<PermissionModule> modules = permissionModuleDAO.listAll();
		return modules;
	}

	@Override
	public void addModule(PermissionModule module) throws PermissionException{

		if(module.getDescription().length()>250)
		{
			throw new PermissionException("Description can not be more than 250 characters");
		}
		else
		{
		permissionModuleDAO.addModule(module);
		}
	}

	@Override
	public List<PermissionModule> getGroupList() {
		List<PermissionModule> listGroup=permissionModuleDAO.listGroup();
		return listGroup;
	}

	@Override
	public PermissionModule getGroup(int id) {
		PermissionModule permissionModule=permissionModuleDAO.get(id);
		return permissionModule;
	}

}
