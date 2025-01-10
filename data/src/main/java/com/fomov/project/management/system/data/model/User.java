package com.fomov.project.management.system.data.model;

import com.fomov.project.management.system.data.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username", length = 20, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 30, nullable = false)
	private String password;

	@Column(name = "role", nullable = false)
	private Role role;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "created_at")
	private Date createdAt;
}
