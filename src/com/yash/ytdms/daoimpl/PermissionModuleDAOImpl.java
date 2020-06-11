package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ytdms.dao.PermissionModuleDAO;
import com.yash.ytdms.domain.PermissionModule;
import com.yash.ytdms.util.JNDIUtil;

public class PermissionModuleDAOImpl extends JNDIUtil implements PermissionModuleDAO {

	@Override
	public List<PermissionModule> listAll() {
		List<PermissionModule> modules = new ArrayList<>();
		String sql = "select *from permissions_module";
		PreparedStatement preparedStatement = preparedStatement(sql);
		try {
			ResultSet resultSet = preparedStatement.executeQuery();
			PermissionModule permissionModule = null;
			while (resultSet.next()) {
				permissionModule = new PermissionModule();
				permissionModule.setDescription(resultSet.getString("description"));
				permissionModule.setId(resultSet.getInt("id"));
				permissionModule.setName(resultSet.getString("name"));
				modules.add(permissionModule);
			}
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			closeConnection();
		}
		return modules;
	}

	@Override
	public void addModule(PermissionModule module) {
		String sql="insert into permissions_module(name,description) values(?,?)";
		PreparedStatement preparedStatement=preparedStatement(sql);
		try {
			preparedStatement.setString(1, module.getName());
			preparedStatement.setString(2, module.getDescription());
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
	}

	@Override
	public List<PermissionModule> listGroup() {
		List<PermissionModule> listModules=new ArrayList<PermissionModule>();
		String sql="select * from permissions_module";
		PermissionModule permissionModule=null;
		PreparedStatement pstmt=preparedStatement(sql);
		ResultSet rs=null;
		try {
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 permissionModule=new PermissionModule();
			     permissionModule.setName(rs.getString("name"));
				 permissionModule.setId(rs.getInt("id"));
				 permissionModule.setDescription(rs.getString("description"));
				 listModules.add(permissionModule);
						
			 }
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return listModules;
	}

	@Override
	public PermissionModule get(int id) {
		PermissionModule permissionModule=null;
		String sql="select * from permissions_module where id=?";
		PreparedStatement pstmt=preparedStatement(sql);	
		ResultSet rs=null;
		try {
			pstmt.setInt(1, id);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 permissionModule=new PermissionModule();
				 permissionModule.setName(rs.getString("name"));
				 permissionModule.setDescription(rs.getString("description"));
				 permissionModule.setId(rs.getInt("id"));
				 
			 }
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return permissionModule;
	}

}
