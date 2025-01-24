package com.fomov.project.management.system.core.facade.impl;

import com.fomov.project.management.system.core.dto.task.TaskRequestDTO;
import com.fomov.project.management.system.core.dto.task.TaskResponseDTO;
import com.fomov.project.management.system.core.facade.TaskFacade;
import com.fomov.project.management.system.core.mapper.task.TaskRequestMapper;
import com.fomov.project.management.system.core.mapper.task.TaskResponseMapper;
import com.fomov.project.management.system.core.service.TaskService;
import com.fomov.project.management.system.data.enums.TaskStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskFacadeImpl implements TaskFacade {
	private final TaskService taskService;

	private final TaskResponseMapper taskResponseMapper;

	private final TaskRequestMapper taskRequestMapper;

	@Override
	public TaskResponseDTO createTaskInProjectById(long projectId, TaskRequestDTO newTaskDTO) {
		return taskResponseMapper.toTaskResponseDTO(
				taskService.createTaskInProjectById(
						projectId, taskRequestMapper.toTaskModel(newTaskDTO)
				)
		);
	}

	@Override
	public List<TaskResponseDTO> getAllProjectTasksById(long projectId) {
		return taskResponseMapper.toTaskResponseDTOs(
				taskService.getAllProjectTasksById(projectId)
		);
	}

	@Override
	public TaskResponseDTO getTaskById(long taskId) {
		return taskResponseMapper.toTaskResponseDTO(
				taskService.getTaskById(taskId)
		);
	}

	@Override
	public TaskResponseDTO updateTaskById(long taskId, TaskRequestDTO updatedTaskDTO) {
		return taskResponseMapper.toTaskResponseDTO(
				taskService.updateTaskById(
						taskId, taskRequestMapper.toTaskModel(updatedTaskDTO)
				)
		);
	}

	@Override
	public void deleteTaskById(long taskId) {
		taskService.deleteTaskById(taskId);
	}

	@Override
	public void assignTaskToUserById(long taskId, long userId) {
		taskService.assignTaskToUserById(taskId, userId);
	}

	@Override
	public void changeTaskStatusById(long taskId, TaskStatus newTaskStatus) {
		taskService.changeTaskStatusById(taskId, newTaskStatus);
	}
}
