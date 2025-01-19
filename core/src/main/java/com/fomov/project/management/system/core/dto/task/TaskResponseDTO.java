package com.fomov.project.management.system.core.dto.task;

import com.fomov.project.management.system.data.enums.TaskPriority;
import com.fomov.project.management.system.data.enums.TaskStatus;
import com.fomov.project.management.system.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {
	private String title;

	private String description;

	private TaskStatus status;

	private User assignedTo;

	private TaskPriority priority;

	private LocalDateTime dueDate;
}
