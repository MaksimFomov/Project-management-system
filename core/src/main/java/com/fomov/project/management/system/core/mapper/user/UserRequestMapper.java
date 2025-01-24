package com.fomov.project.management.system.core.mapper.user;

import com.fomov.project.management.system.core.dto.user.UserRequestDTO;
import com.fomov.project.management.system.data.model.User;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
	User toUserModel(UserRequestDTO userRequestDTO);

	Set<User> toUserModels(Set<UserRequestDTO> userRequestDTOs);
}
