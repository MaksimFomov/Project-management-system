package com.fomov.project.management.system.data.model;

import com.fomov.project.management.system.data.enums.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", length = 20, nullable = false)
	private String name;

	@Column(name = "description", length = 100, nullable = false)
	private String description;

	@ManyToOne
	private User ownerId;

	@ManyToMany
	private Set<User> team;

	@Column(name = "status", nullable = false)
	private ProjectStatus status;

	@Column(name = "created_at")
	private Date createdAt;
}
