package com.fomov.project.management.system.core.mapper.user;

import com.fomov.project.management.system.core.dto.user.UserResponseDTO;
import com.fomov.project.management.system.data.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
	UserResponseDTO toUserResponseDTO(User user);

	List<UserResponseDTO> toUserResponseDTOs(List<User> users);
}
