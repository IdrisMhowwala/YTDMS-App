package com.yash.ytdms.service;

import java.util.List;

import com.yash.ytdms.domain.Notification;

public interface NotificationService {
	int ADD_OPERATION_TYPE=1;
	int DELETE_OPERATION_TYPE=2;
	int UPDATE_OPERATION_TYPE=3;
	int CATEGORY_ITEM_TYPE=1;
	int SECTION_ITEM_TYPE=2;
	int DOCUMENT_ITEM_TYPE=3;
	int GROUP_ITEM_TYPE=4;

	/**
	 * This method gets all notifications from the system
	 * @param managerUserId is the id corresponding to which notifications are to be got.
	 * @return List of notifications
	 */
	List<Notification> getAllNotifications(int managerUserId);

	void createNotification(Notification notification); 

	void removeNotification(Notification notification);

	void editNotificationDetail(Notification notification);

}
