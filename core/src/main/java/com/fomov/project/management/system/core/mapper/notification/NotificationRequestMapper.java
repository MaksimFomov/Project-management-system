package com.fomov.project.management.system.core.mapper.notification;

import com.fomov.project.management.system.core.dto.notification.NotificationRequestDTO;
import com.fomov.project.management.system.data.model.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationRequestMapper {
	Notification toNotificationModel(NotificationRequestDTO notificationRequestDTO);
}
