package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ytdms.dao.RoleDAO;

import com.yash.ytdms.domain.Role;

import com.yash.ytdms.util.JNDIUtil;

public class RoleDAOImpl extends JNDIUtil implements RoleDAO {

	@Override
	public List<Role> listAll() {
		List<Role> roles = new ArrayList<>();
		String sql = "select * from roles";
		PreparedStatement preparedStatement = preparedStatement(sql);
		try {
			ResultSet resultSet = preparedStatement.executeQuery();
			Role role = null;
			while (resultSet.next()) {
				role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				roles.add(role);

			}

			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			closeConnection();
		}
		return roles;

	}

	@Override
	public void addRole(Role role) {
		String sql = "insert into roles(name) values(?)";
		PreparedStatement preparedStatement = preparedStatement(sql);
		try {
			preparedStatement.setString(1, role.getName());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}

	}

}
