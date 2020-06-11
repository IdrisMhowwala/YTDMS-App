package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ytdms.dao.PermissionDAO;
import com.yash.ytdms.domain.Permission;
import com.yash.ytdms.util.JNDIUtil;

public class PermissionDAOImpl extends JNDIUtil implements PermissionDAO {

	@Override
	public List<Permission> permissionsByRole(int moduleId) {
		List<Permission> roles = new ArrayList<Permission>();
		String sql = "SELECT * FROM permissions WHERE module_id=?";
		PreparedStatement preparedStatement = preparedStatement(sql);
		try {
			preparedStatement.setInt(1, moduleId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Permission permission = new Permission();
				permission.setId(resultSet.getInt("id"));
				permission.setName(resultSet.getString("name"));
				permission.setModuleId(resultSet.getInt("module_id"));
				roles.add(permission);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return roles;

	}

	@Override
	public List<Permission> list(int moduleId) {
		List<Permission> list=new ArrayList<Permission>();
		String sql="select * from permissions where module_id=?";
		PreparedStatement pstmt=preparedStatement(sql);	
		ResultSet rs=null;
		try {
			pstmt.setInt(1, moduleId);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 Permission permission=new Permission();
			     permission.setName(rs.getString("name"));
				 permission.setId(rs.getInt("id"));
				 permission.setModuleId(rs.getInt("module_id"));
				 list.add(permission);
						
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return list;
	}

	@Override
	public String get(int groupId) {
		String groupName="";
		String sql="select name from permissions_module where id=?";
		PreparedStatement pstmt=preparedStatement(sql);	
		ResultSet rs=null;
		try {
			pstmt.setInt(1, groupId);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 groupName+=rs.getString("name");
						
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return groupName;
	}

	@Override
	public Permission getAll(int permissionId) {
		Permission permission=null;
		String sql="select * from permissions where id=?";
		PreparedStatement pstmt=preparedStatement(sql);	
		ResultSet rs=null;
		try {
			pstmt.setInt(1, permissionId);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 permission=new Permission();
			     permission.setName(rs.getString("name"));
				 permission.setId(rs.getInt("id"));
				 permission.setModuleId(rs.getInt("module_id"));
				 
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return permission;
	}

	@Override
	public void insert(Permission permission) {
		String sql="insert into permissions(name,id,module_id) values(?,?,?)";
		PreparedStatement pstmt=preparedStatement(sql);
		try {
			pstmt.setString(1, permission.getName());
			pstmt.setInt(2, permission.getId());
			pstmt.setInt(3, permission.getModuleId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
	}

	@Override
	public void update(Permission permission) {
		String sql="update permissions set name=? where id=?";
		PreparedStatement pstmt=preparedStatement(sql);
		try {
			pstmt.setString(1,permission.getName());
			pstmt.setInt(2, permission.getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
	}

	@Override
	public void delete(int permissionId) {
		String firstSql="delete from role_permissions where permission_id=?";
		String sql="delete from permissions where id=?";
		try{
			PreparedStatement pstmt=preparedStatement(firstSql);
			pstmt.setInt(1,permissionId);
			pstmt.execute();
			pstmt.close();
			pstmt=preparedStatement(sql);
			pstmt.setInt(1, permissionId);
			pstmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
	}

}
