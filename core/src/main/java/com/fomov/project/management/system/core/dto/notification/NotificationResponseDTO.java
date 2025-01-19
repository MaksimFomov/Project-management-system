package com.fomov.project.management.system.core.dto.notification;

import com.fomov.project.management.system.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponseDTO {
	private String content;

	private User recipient;

	private Boolean read;

	private LocalDateTime createdAt;
}
