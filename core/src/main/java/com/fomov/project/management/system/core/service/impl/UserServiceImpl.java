package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.exception.notfound.UserNotFoundException;
import com.fomov.project.management.system.core.service.UserService;
import com.fomov.project.management.system.data.model.User;
import com.fomov.project.management.system.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
	}

	@Transactional
	@Override
	public User updateUserById(long userId, User updatedUser) {
		User existingUser = getUserById(userId);

		existingUser.setUsername(updatedUser.getUsername());
		existingUser.setPassword(updatedUser.getPassword());
		existingUser.setEmail(updatedUser.getEmail());

		return userRepository.save(existingUser);
	}

	@Transactional
	@Override
	public void deleteUserById(long userId) {
		userRepository.delete(getUserById(userId));
	}
}
