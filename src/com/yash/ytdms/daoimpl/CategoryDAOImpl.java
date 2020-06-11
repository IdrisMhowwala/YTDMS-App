package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yash.ytdms.dao.CategoryDAO;
import com.yash.ytdms.domain.Category;
import com.yash.ytdms.util.JNDIUtil;

/**
 * This is class which contains method for crud operation
 * 
 * @author yash.nahar
 *
 */
public class CategoryDAOImpl extends JNDIUtil implements CategoryDAO {

	@Override
	public int save(Category category) {
		String sql = "INSERT INTO categories(name,description,creation_date,visibility_status,permission_status,userId) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = preparedStatement(sql);
		int categoryId = 0;
		try {
			pstmt.setString(1, category.getName());
			pstmt.setString(2, category.getDescription());
			pstmt.setDate(3, category.getCreation_date());
			pstmt.setInt(4, category.getVisibility_status());
			pstmt.setInt(5, category.getPermission_status());
			pstmt.setInt(6, category.getUserId());
			pstmt.execute();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				categoryId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return categoryId;
	}

	@Override
	public List<Category> findAll() {

		Category category = null;
		String sql = "select * from categories order by id DESC ";
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = preparedStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				category.setCreation_date(rs.getDate("creation_date"));
				category.setVisibility_status(rs.getInt("visibility_status"));
				category.setPermission_status(rs.getInt("permission_status"));
				category.setRejectionMessage(rs.getString("rejectionMessage"));
				categories.add(category);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return categories;
	}

	@Override
	public List<Category> findAll(int managerUserId) {
		List<Category> categories = new ArrayList<Category>();
		String sql = "select * from categories where userId in (select id from users where mgrId=?)";
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setInt(1, managerUserId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				category.setCreation_date(rs.getDate("creation_date"));
				category.setVisibility_status(rs.getInt("visibility_status"));
				category.setPermission_status(rs.getInt("permission_status"));
				category.setUserId(rs.getInt("userId"));
				category.setRejectionMessage(rs.getString("rejectionMessage"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return categories;

	}

	@Override
	public void changeStatus(int id, int visibilityStatus) {
		String sql = "update categories set visibility_status=? where id=?";
		try {
			PreparedStatement preparedStatement = preparedStatement(sql);
			preparedStatement.setInt(1, visibilityStatus);
			preparedStatement.setInt(2, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public void update(Category category) {
		String sql = "update categories set name=?, description=?, creation_date=?,"
				+ "permission_status=?,visibility_status=?,userId=?,rejectionMessage=? where id=?";
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setString(1, category.getName());
			pstmt.setString(2, category.getDescription());
			pstmt.setDate(3, (java.sql.Date) category.getCreation_date());
			pstmt.setInt(4, category.getPermission_status());
			pstmt.setInt(5, category.getVisibility_status());
			pstmt.setInt(6, category.getUserId());
			pstmt.setString(7, category.getRejectionMessage());
			pstmt.setInt(8, category.getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	@Override
	public void delete(Category category) {

		String sql = "delete from categories where id=?";
		try {
			PreparedStatement pstmt = preparedStatement(sql);
			pstmt.setInt(1, category.getId());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public Category find(int categoryId) {
		String sql = "select * from categories where id=?";
		PreparedStatement pstmt = preparedStatement(sql);
		Category category = null;
		try {
			pstmt.setInt(1, categoryId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				category.setPermission_status(rs.getInt("permission_status"));
				category.setVisibility_status(rs.getInt("visibility_status"));
				category.setCreation_date(rs.getDate("creation_date"));
				category.setUserId(rs.getInt("userId"));
				category.setRejectionMessage(rs.getString("rejectionMessage"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return category;
	}

	@Override
	public void delete(int id) {

	}

}
