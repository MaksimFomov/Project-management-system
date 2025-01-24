package com.fomov.project.management.system.core.facade;

import com.fomov.project.management.system.core.dto.user.UserRequestDTO;
import com.fomov.project.management.system.core.dto.user.UserResponseDTO;

import java.util.List;

public interface UserFacade {
	List<UserResponseDTO> getAllUsers();

	UserResponseDTO getUserById(long userId);

	UserResponseDTO updateUserById(long userId, UserRequestDTO updatedUserDTO);

	void deleteUserById(long userId);
}
