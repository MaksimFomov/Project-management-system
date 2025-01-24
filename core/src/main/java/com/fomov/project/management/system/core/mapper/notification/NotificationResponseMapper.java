package com.fomov.project.management.system.core.mapper.notification;

import com.fomov.project.management.system.core.dto.notification.NotificationResponseDTO;
import com.fomov.project.management.system.data.model.Notification;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationResponseMapper {
	NotificationResponseDTO toNotificationResponseDTO(Notification notification);

	List<NotificationResponseDTO> toNotificationResponseDTOs(List<Notification> notifications);
}
