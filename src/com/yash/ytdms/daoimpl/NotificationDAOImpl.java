package com.yash.ytdms.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ytdms.dao.NotificationDAO;
import com.yash.ytdms.domain.Notification;
import com.yash.ytdms.util.JNDIUtil;

public class NotificationDAOImpl extends JNDIUtil implements NotificationDAO {

	@Override
	public List<Notification> findAll(int managerUserId) {
		List<Notification> notifications = new ArrayList<Notification>();
		String sql = "select * from notifications where sentTo=? ORDER BY id DESC";
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setInt(1, managerUserId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Notification notification = new Notification();
				notification.setId(rs.getInt("id"));
				notification.setGeneratedBy(rs.getInt("generatedBy"));
				notification.setN_item_id(rs.getInt("n_item_id"));
				notification.setN_item_type(rs.getInt("n_item_type"));
				notification.setN_operation_type(rs.getInt("n_operation_type"));
				notification.setSentDate(rs.getDate("sentDate"));
				notification.setMessage(rs.getString("message"));
				notifications.add(notification);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return notifications;
	}

	@Override
	public void save(Notification notification) {
		String sql = "insert into notifications(message,generatedBy,sentTo,sentDate,n_operation_type,n_item_type,n_item_id) values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setString(1, notification.getMessage());
			pstmt.setInt(2, notification.getGeneratedBy());
			pstmt.setInt(3, notification.getSentTo());
			pstmt.setDate(4, notification.getSentDate());
			pstmt.setInt(5, notification.getN_operation_type());
			pstmt.setInt(6, notification.getN_item_type());
			pstmt.setInt(7, notification.getN_item_id());

			pstmt.execute();
		} catch (Exception e) {

		} finally {
			closeConnection();
		}

	}

	@Override
	public void update(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
