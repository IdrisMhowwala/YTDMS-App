package com.yash.ytdms.serviceimpl;

import java.util.List;

import com.yash.ytdms.dao.NotificationDAO;
import com.yash.ytdms.daoimpl.NotificationDAOImpl;
import com.yash.ytdms.domain.Notification;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.NotificationService;

public class NotificationServiceImpl implements NotificationService {
	private NotificationDAO notificationDAO = null;

	public NotificationServiceImpl() {
		notificationDAO = (NotificationDAO) ObjectFactory.getObject(NotificationDAO.class);
	}
	@Override
	public List<Notification> getAllNotifications(int managerUserId) {
		List<Notification> notifications = notificationDAO.findAll(managerUserId);
		return notifications;
	}
	@Override
	public void createNotification(Notification notification) {
		notificationDAO.save(notification);
		
		
	}

	@Override
	public void removeNotification(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editNotificationDetail(Notification notification) {
		// TODO Auto-generated method stub
		
	}



}
