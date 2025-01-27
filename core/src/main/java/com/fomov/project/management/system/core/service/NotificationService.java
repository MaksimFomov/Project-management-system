package com.fomov.project.management.system.core.service;

import com.fomov.project.management.system.data.model.Notification;

import java.util.List;

public interface NotificationService {
	List<Notification> getAllUserNotificationsById(long userId);

	void markNotificationAsReadById(long notificationId);
}
