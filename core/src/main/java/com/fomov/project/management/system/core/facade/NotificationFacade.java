package com.fomov.project.management.system.core.facade;

import com.fomov.project.management.system.core.dto.notification.NotificationResponseDTO;
import com.fomov.project.management.system.data.model.Notification;

import java.util.List;

public interface NotificationFacade {
	List<NotificationResponseDTO> getAllUserNotificationById(long userId);

	void markNotificationAsReadById(long notificationId);
}
