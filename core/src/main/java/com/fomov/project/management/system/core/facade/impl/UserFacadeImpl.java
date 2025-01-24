package com.fomov.project.management.system.core.facade.impl;

import com.fomov.project.management.system.core.dto.user.UserRequestDTO;
import com.fomov.project.management.system.core.dto.user.UserResponseDTO;
import com.fomov.project.management.system.core.facade.UserFacade;
import com.fomov.project.management.system.core.mapper.user.UserRequestMapper;
import com.fomov.project.management.system.core.mapper.user.UserResponseMapper;
import com.fomov.project.management.system.core.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {
	private final UserService userService;

	private final UserRequestMapper userRequestMapper;

	private final UserResponseMapper userResponseMapper;

	@Override
	public List<UserResponseDTO> getAllUsers() {
		return userResponseMapper.toUserResponseDTOs(
				userService.getAllUsers()
		);
	}

	@Override
	public UserResponseDTO getUserById(long userId) {
		return userResponseMapper.toUserResponseDTO(
				userService.getUserById(userId)
		);
	}

	@Override
	public UserResponseDTO updateUserById(long userId, UserRequestDTO updatedUserDTO) {
		return userResponseMapper.toUserResponseDTO(
				userService.updateUserById(
						userId, userRequestMapper.toUserModel(updatedUserDTO)
				)
		);
	}

	@Override
	public void deleteUserById(long userId) {
		userService.deleteUserById(userId);
	}
}
