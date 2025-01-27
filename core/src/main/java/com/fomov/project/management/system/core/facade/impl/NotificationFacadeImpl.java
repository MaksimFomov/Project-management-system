package com.fomov.project.management.system.core.facade.impl;

import com.fomov.project.management.system.core.dto.notification.NotificationResponseDTO;
import com.fomov.project.management.system.core.facade.NotificationFacade;
import com.fomov.project.management.system.core.mapper.notification.NotificationResponseMapper;
import com.fomov.project.management.system.core.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationFacadeImpl implements NotificationFacade {
	private final NotificationService notificationService;

	private final NotificationResponseMapper notificationResponseMapper;

	@Override
	public List<NotificationResponseDTO> getAllUserNotificationsById(long userId) {
		return notificationResponseMapper.toNotificationResponseDTOs(
				notificationService.getAllUserNotificationById(userId)
		);
	}

	@Override
	public void markNotificationAsReadById(long notificationId) {
		notificationService.markNotificationAsReadById(notificationId);
	}
}
