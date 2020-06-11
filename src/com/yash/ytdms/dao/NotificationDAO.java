package com.yash.ytdms.dao;

import java.util.List;

import com.yash.ytdms.domain.Notification;

public interface NotificationDAO {

	/**
	 * This method gets all notification sent to the particular user
	 * @param managerUserId userId to which notifications are sentTo
	 * @return list of notifications
	 */
	List<Notification> findAll(int managerUserId);
	/**
	 * This save method will save the Notification in notifications
	 * 
	 * @param Notification to be saved
	 */
	void save(Notification notification);

	/**
	 * This update method will update the Notification in notifications.
	 * 
	 * @param Notification to be updated
	 */
	void update(Notification notification);

	/**
	 * This delete method will delete the Notification from the notifications
	 * 
	 * @param Notification to be deleted
	 */
	void delete(Notification notification);

	/**
	 * This delete method will delete the Notification from the notificaitons based on provided
	 * id
	 * 
	 * @param id of the Notification to be deleted.
	 */
	void delete(int id);

}
