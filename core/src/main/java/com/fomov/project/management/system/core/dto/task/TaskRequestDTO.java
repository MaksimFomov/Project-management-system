package com.fomov.project.management.system.core.dto.task;

import com.fomov.project.management.system.data.enums.TaskPriority;
import com.fomov.project.management.system.data.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {
	private String title;

	private String description;

	private TaskStatus status;

	private TaskPriority priority;
}
