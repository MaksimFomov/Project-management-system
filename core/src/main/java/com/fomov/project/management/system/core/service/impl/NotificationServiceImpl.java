package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.service.NotificationService;
import com.fomov.project.management.system.data.model.Notification;
import com.fomov.project.management.system.data.repository.NotificationRepository;
import com.fomov.project.management.system.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
	private final NotificationRepository notificationRepository;
	private final UserRepository userRepository;

	public NotificationServiceImpl(NotificationRepository notificationRepository, UserRepository userRepository) {
		this.notificationRepository = notificationRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Notification> getAllUserNotificationById(long userId) {
		return notificationRepository.findByRecipient(
				userRepository.findById(userId)
						.orElseThrow()
		);
	}

	@Transactional
	@Override
	public void markNotificationAsReadById(long notificationId) {
		Notification existNotification = notificationRepository.findById(notificationId)
				.orElseThrow();

		existNotification.setRead(true);

		notificationRepository.save(existNotification);
	}
}
