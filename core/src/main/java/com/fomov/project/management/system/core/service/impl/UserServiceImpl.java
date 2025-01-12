package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.service.UserService;
import com.fomov.project.management.system.data.model.User;
import com.fomov.project.management.system.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		return userRepository.findById(userId)
				.orElseThrow();
	}

	//доработать
	@Transactional
	@Override
	public User updateUserById(long userId, User updatedUser) {
		User existingUser = userRepository.findById(userId)
				.orElseThrow();

		existingUser.setUsername(updatedUser.getUsername());
		existingUser.setPassword(updatedUser.getPassword());
		existingUser.setRole(updatedUser.getRole());
		existingUser.setEmail(updatedUser.getEmail());

		return userRepository.save(existingUser);
	}

	@Transactional
	@Override
	public void deleteUserById(long userId) {
		userRepository.delete(
				userRepository.findById(userId)
						.orElseThrow()
		);
	}
}
