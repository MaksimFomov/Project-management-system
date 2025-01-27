package com.fomov.project.management.system.core.facade;

import com.fomov.project.management.system.core.dto.notification.NotificationResponseDTO;

import java.util.List;

public interface NotificationFacade {
	List<NotificationResponseDTO> getAllUserNotificationsById(long userId);

	void markNotificationAsReadById(long notificationId);
}
