package com.fomov.project.management.system.core.dto.notification;

import com.fomov.project.management.system.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequestDTO {
	private String content;

	private User recipient;
}
