package com.fomov.project.management.system.data.model;

import com.fomov.project.management.system.data.enums.TaskPriority;
import com.fomov.project.management.system.data.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "title", length = 20, nullable = false)
	private String title;

	@Column(name = "description", length = 100)
	private String description;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private TaskStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_to")
	private User assignedTo;

	@Column(name = "priority", nullable = false)
	@Enumerated(EnumType.STRING)
	private TaskPriority priority;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id")
	private List<Comment> comments = new ArrayList<>();

	@Column(name = "due_date")
	private LocalDateTime dueDate;
}
