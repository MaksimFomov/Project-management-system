package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.exception.notfound.NotificationNotFoundException;
import com.fomov.project.management.system.core.service.NotificationService;
import com.fomov.project.management.system.core.service.UserService;
import com.fomov.project.management.system.data.model.Notification;
import com.fomov.project.management.system.data.repository.NotificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
	private final NotificationRepository notificationRepository;
	private final UserService userService;

	@Override
	public List<Notification> getAllUserNotificationsById(long userId) {
		return notificationRepository.findByRecipient(
				userService.getUserById(userId)
		);
	}

	@Transactional
	@Override
	public void markNotificationAsReadById(long notificationId) {
		Notification existNotification = notificationRepository.findById(notificationId)
				.orElseThrow(() -> new NotificationNotFoundException("Notification not found with ID: " + notificationId));

		existNotification.setRead(true);

		notificationRepository.save(existNotification);
	}
}
