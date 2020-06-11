package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.yash.ytdms.dao.UserDAO;
import com.yash.ytdms.domain.User;
import com.yash.ytdms.util.JNDIUtil;

public class UserDAOImpl extends JNDIUtil implements UserDAO {

	@Override
	public void save(User user) {
		
		String sql="INSERT INTO users(NAME,email,PASSWORD,groupId,role) values(?,?,?,?,?)";
		PreparedStatement pstmt =preparedStatement(sql);
		
	
		try {
			pstmt.setString(1, user.getName());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getGroupDropDown());
			pstmt.setInt(5, user.getRole());
			pstmt.execute();

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally 
		{
			closeConnection();
		}
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}
	

}
