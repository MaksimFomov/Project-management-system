package com.fomov.project.management.system.data.model;

import com.fomov.project.management.system.data.enums.TaskPriority;
import com.fomov.project.management.system.data.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "title", length = 20, nullable = false)
	private String title;

	@Column(name = "description", length = 100, nullable = false)
	private String description;

	@Column(name = "status", nullable = false)
	private TaskStatus status;

	@ManyToOne
	private User assignedTo;

	@Column(name = "priority", nullable = false)
	private TaskPriority priority;

	@ManyToOne
	private Project projectId;

	@Column(name = "due_date")
	private Date dueDate;
}
