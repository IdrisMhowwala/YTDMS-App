package com.yash.ytdms.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ytdms.dao.RoleDAO;
import com.yash.ytdms.domain.Permission;
import com.yash.ytdms.domain.PermissionModule;
import com.yash.ytdms.domain.Role;
import com.yash.ytdms.exception.RoleException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.RoleService;
import com.yash.ytdms.util.JNDIUtil;

public class RoleServiceImpl extends JNDIUtil implements RoleService {

	private RoleDAO roleDAO;

	public RoleServiceImpl() {
		roleDAO = (RoleDAO) ObjectFactory.getObject(RoleDAO.class);
	}

	@Override
	public List<Role> listRoles() {
		List<Role> roles = roleDAO.listAll();
		return roles;
	}

	@Override
	public Role assignPermissionsToRole(Role role) throws RoleException {
		List<PermissionModule> permissionModules = role.getPermissionModules();
		if (role.getId() == null) {
			throw new RoleException("No Role selected");
		}
		if (permissionModules == null) {
			throw new RoleException("No Permissions selected");
		}
		List<Permission> permissions;
		PermissionModule permissionModule = permissionModules.get(0);
		permissions = permissionModule.getPermissions();
		int moduleId = permissionModule.getId();
		int roleId = role.getId();
		insertOperation(permissions, moduleId, roleId);
		Role newRole = selectName(roleId);
		return newRole;
	}

	private Role selectName(int roleId) {
		String sql;
		PreparedStatement preparedStatement;
		sql = "select name from roles where id=?";
		Role newRole = new Role();
		try {
			preparedStatement = preparedStatement(sql);
			preparedStatement.setInt(1, roleId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				newRole.setName(resultSet.getString("name"));
				closeConnection();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return newRole;
	}

	private void insertOperation(List<Permission> permissions, int moduleId, int roleId) {
		String sql = "insert into role_permissions values(?,?,?)";
		PreparedStatement preparedStatement;
		for (Permission permission : permissions) {
			preparedStatement = preparedStatement(sql);
			try {
				preparedStatement.setInt(1, roleId);
				preparedStatement.setInt(2, permission.getId());
				preparedStatement.setInt(3, moduleId);
				preparedStatement.execute();
				preparedStatement.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
	}

	@Override
	public void addRole(Role role) {
				roleDAO.addRole(role);
			
	}
	

	
	public Role getRoleById(int roleId)
	{
		Role role=new Role();
		try
		{
		
		role.setId(roleId);
		String sql="select name from roles where id=?";
		PreparedStatement preparedStatement=preparedStatement(sql);
		preparedStatement.setInt(1, roleId);
		ResultSet resultSet1=preparedStatement.executeQuery();
		if(resultSet1.next())
		{
			role.setName(resultSet1.getString("name"));
		}
		resultSet1.close();
		preparedStatement.close();
		
		
		sql="select module_id from role_permissions where role_id=? group by module_id";
		preparedStatement=preparedStatement(sql);
		preparedStatement.setInt(1, roleId);
		ResultSet resultSet=preparedStatement.executeQuery();
		List<PermissionModule>permissionModules=new ArrayList<>();
		role.setPermissionModules(permissionModules);
		
		while(resultSet.next())
		{
			PermissionModule permissionModule=new PermissionModule();
			permissionModule.setId(resultSet.getInt("module_id"));
			sql="select name from permissions_module where id="+permissionModule.getId();
			ResultSet rs;
			PreparedStatement ps=preparedStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
			{
				permissionModule.setName(rs.getString("name"));
			}
			rs.close();
			ps.close();
			List<Permission>permissions=new ArrayList<>();
			permissionModule.setPermissions(permissions);
			permissionModules.add(permissionModule);
		}
		resultSet.close();
		preparedStatement.close();
		
		for(PermissionModule p:permissionModules)
		{
			sql="select permission_id from role_permissions where module_id="+p.getId();
			List<Permission>permissions = new ArrayList<>();
			PreparedStatement preparedStatement2=preparedStatement(sql);
			ResultSet resultSet2=preparedStatement2.executeQuery();
			while(resultSet2.next())
			{
				Permission permission=new Permission();
				permission.setId(resultSet2.getInt("permission_id"));
				sql="select name from permissions where id="+permission.getId();
				PreparedStatement preparedStatement3=preparedStatement(sql);
				ResultSet resultSet3=preparedStatement3.executeQuery();
				while(resultSet3.next())
				{
					permission.setName(resultSet3.getString("name"));
				}
//				resultSet3.close();
//				preparedStatement3.close();
				permissions.add(permission);
			}
			closeConnection();
			
			p.setPermissions(permissions);
		
		}
		}catch(SQLException sqlException)
		{
			System.out.println(sqlException);
			sqlException.printStackTrace();
		}
		return role;
	}
	
	
	
		

}
