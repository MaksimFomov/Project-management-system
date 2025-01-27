package com.fomov.project.management.system.web.controller;

import com.fomov.project.management.system.core.dto.notification.NotificationResponseDTO;
import com.fomov.project.management.system.core.exception.notfound.NotificationNotFoundException;
import com.fomov.project.management.system.core.exception.notfound.UserNotFoundException;
import com.fomov.project.management.system.core.facade.NotificationFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/notifications")
public class NotificationController {
	private final NotificationFacade notificationFacade;

	//check
	@GetMapping
	public ResponseEntity<?> getAllUserNotificationsById() {
		try {
			long userId = 0;
			List<NotificationResponseDTO> notificationResponseDTOs = notificationFacade.getAllUserNotificationsById(userId);

			return ResponseEntity.status(HttpStatus.OK).body(notificationResponseDTOs);
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/{notificationId}/mark-as-read")
	public ResponseEntity<?> markNotificationAsReadById(@PathVariable long notificationId) {
		try {
			notificationFacade.markNotificationAsReadById(notificationId);

			return ResponseEntity.status(HttpStatus.OK).body("Notification marked as read");
		} catch (NotificationNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
