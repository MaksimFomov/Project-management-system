package com.fomov.project.management.system.core.service;

import com.fomov.project.management.system.data.model.User;

import java.util.List;

public interface UserService {
	List<User> getAllUsers();

	User getUserById(long userId);

	User updateUserById(long userId, User updatedUser);

	void deleteUserById(long userId);
}
