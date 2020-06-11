package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ytdms.dao.GroupDAO;
import com.yash.ytdms.domain.Group;
import com.yash.ytdms.domain.User;
import com.yash.ytdms.util.JNDIUtil;

/**
 * this is the implementation class of GroupDAO
 * 
 * @author prateek.dubey
 *
 */
public class GroupDAOImpl extends JNDIUtil implements GroupDAO {

	@Override
	public List<Group> findAll(int role) {
		String sql = null;
		if (role == 1) {
			sql = "select * from groups";
		} else if (role == 2) {
			sql = "select * from groups where status=1";
		} else {
			sql = "select * from groups where status=1";
		}

		List<Group> groups = new ArrayList<Group>();
		PreparedStatement pstmt = preparedStatement(sql);
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Group group = new Group();
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("name"));
				group.setStart_date(rs.getDate("start_date"));
				group.setEnd_date(rs.getDate("end_date"));
				group.setStatus(rs.getInt("status"));
				group.setDescription(rs.getString("description"));
				group.setCreatedBy(rs.getString("createdBy"));
				group.setUpdatedBy(rs.getString("updatedBy"));

				groups.add(group);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return groups;
	}

	@Override
	public List<User> findById(int id){
		
		String sql="select status from groups where id="+id;
		PreparedStatement pstmt=preparedStatement(sql);
		
		try {
			ResultSet resultSet=pstmt.executeQuery();
			if(resultSet.next())
			{
				if(resultSet.getInt("status")==1);
				else
				{
					return null;
				}
			pstmt.close();
			resultSet.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		sql = "select * from users where groupId=" + id + " and role=3";
		User user;
		List<User> groups = new ArrayList<User>();
		pstmt = preparedStatement(sql);
		ResultSet rs;
		String name;
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				System.out.println("Resultset found ! ------------------in DAOIMPL");
				Group group = new Group();
				// group.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setId(rs.getInt("id"));
				// group.setStart_date(rs.getDate("start_date"));
				// group.setEnd_date(rs.getDate("end_date"));
				// group.setStatus(rs.getInt("status"));
				// group.setDescription(rs.getString("description"));
				// group.setCreatedBy(rs.getString("createdBy"));
				// group.setUpdatedBy(rs.getString("updatedBy"));

				groups.add(user);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return groups;
	}

	@Override
	public List<Group> findAllGroups(int userId) {
		String sql = "SELECT * FROM groups WHERE userId=" + userId + " and status=1";

		List<Group> groups = new ArrayList<>();

		Group group = null;

		try {
			PreparedStatement pstmt = preparedStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				group = new Group();
				group.setId(rs.getInt("id"));
				group.setUserId(rs.getInt("userId"));
				group.setName(rs.getString("name"));
				group.setDescription(rs.getString("description"));
				group.setStatus(rs.getInt("status"));
				group.setCreatedBy(rs.getString("createdBy"));
				group.setUpdatedBy(rs.getString("updatedBy"));
				group.setStart_date(rs.getDate("start_date"));
				group.setEnd_date(rs.getDate("end_date"));
				groups.add(group);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return groups;
	}

	/**
	 * 
	 */
	@Override
	public void update(Group group) {

		String sql = "UPDATE groups SET name=?, description=? WHERE id= ?";
		try {
			PreparedStatement pstmt = preparedStatement(sql);
			pstmt.setString(1, group.getName());
			pstmt.setString(2, group.getDescription());
			pstmt.setInt(3, group.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public void insert(Group group) {

		String sql = "INSERT into groups(name,userId,description,status,createdBy,updatedBy,start_date,end_date) values(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = preparedStatement(sql);
		try {
			preparedStatement.setString(1, group.getName());
			System.out.println(group.getUserId());
			preparedStatement.setInt(2, group.getUserId());
			preparedStatement.setString(3, group.getDescription());
			preparedStatement.setInt(4, group.getStatus());
			preparedStatement.setString(5, group.getCreatedBy());
			preparedStatement.setString(6, group.getUpdatedBy());
			preparedStatement.setDate(7, new java.sql.Date(group.getStart_date().getTime()));
			preparedStatement.setDate(8, new java.sql.Date(group.getEnd_date().getTime()));
			preparedStatement.execute();
			System.out.println("Data Inserted !");
		} 	catch (SQLException e) {
			System.out.println("Data is not inserted due to ERROR occurred !");
			System.out.println("ERROR : " + e);
		}

	}

}
