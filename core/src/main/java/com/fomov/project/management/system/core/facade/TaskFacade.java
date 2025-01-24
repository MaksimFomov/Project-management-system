package com.fomov.project.management.system.core.facade;

import com.fomov.project.management.system.core.dto.task.TaskRequestDTO;
import com.fomov.project.management.system.core.dto.task.TaskResponseDTO;
import com.fomov.project.management.system.data.enums.TaskStatus;
import com.fomov.project.management.system.data.model.Task;

import java.util.List;

public interface TaskFacade {
	TaskResponseDTO createTaskInProjectById(long projectId, TaskRequestDTO newTaskDTO);

	List<TaskResponseDTO> getAllProjectTasksById(long projectId);

	TaskResponseDTO getTaskById(long taskId);

	TaskResponseDTO updateTaskById(long taskId, TaskRequestDTO updatedTaskDTO);

	void deleteTaskById(long taskId);

	void assignTaskToUserById(long taskId, long userId);

	void changeTaskStatusById(long taskId, TaskStatus newTaskStatus);
}
