package com.fomov.project.management.system.web.controller;

import com.fomov.project.management.system.core.dto.user.UserRequestDTO;
import com.fomov.project.management.system.core.dto.user.UserResponseDTO;
import com.fomov.project.management.system.core.exception.notfound.UserNotFoundException;
import com.fomov.project.management.system.core.facade.UserFacade;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	private final UserFacade userFacade;

	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		try {
			List<UserResponseDTO> userResponseDTOs = userFacade.getAllUsers();

			return ResponseEntity.status(HttpStatus.OK).body(userResponseDTOs);
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable long userId) {
		try {
			UserResponseDTO userResponseDTO = userFacade.getUserById(userId);

			return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/{userId}")
	public ResponseEntity<?> updateUserById(@PathVariable long userId, @Valid @RequestBody UserRequestDTO userRequestDTO) {
		try {
			UserResponseDTO userResponseDTO = userFacade.updateUserById(userId, userRequestDTO);

			return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable long userId) {
		try {
			userFacade.deleteUserById(userId);

			return ResponseEntity.status(HttpStatus.OK).body("User successfully deleted.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
