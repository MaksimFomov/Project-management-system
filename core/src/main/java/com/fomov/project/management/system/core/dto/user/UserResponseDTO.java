package com.fomov.project.management.system.core.dto.user;

import com.fomov.project.management.system.data.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
	private String username;

	private Role role;

	private String email;

	private LocalDateTime createdAt;
}
