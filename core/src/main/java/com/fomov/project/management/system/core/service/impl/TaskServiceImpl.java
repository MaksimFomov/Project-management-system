package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.exception.notfound.TaskNotFoundException;
import com.fomov.project.management.system.core.service.ProjectService;
import com.fomov.project.management.system.core.service.TaskService;
import com.fomov.project.management.system.core.service.UserService;
import com.fomov.project.management.system.data.enums.TaskStatus;
import com.fomov.project.management.system.data.model.Project;
import com.fomov.project.management.system.data.model.Task;
import com.fomov.project.management.system.data.model.User;
import com.fomov.project.management.system.data.repository.ProjectRepository;
import com.fomov.project.management.system.data.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
	private final TaskRepository taskRepository;
	private final ProjectRepository projectRepository;
	private final UserService userService;
	private final ProjectService projectService;

	@Transactional
	@Override
	public Task createTaskInProjectById(long projectId, Task newTask) {
		Project existProject = projectService.getProjectById(projectId);
		existProject.getTasks().add(newTask);

		projectRepository.save(existProject);

		return newTask;
	}

	@Override
	public List<Task> getAllProjectTasksById(long projectId) {
		return projectService.getProjectById(projectId).getTasks();
	}

	@Override
	public Task getTaskById(long taskId) {
		return taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskNotFoundException("Task not found with ID: " + taskId));
	}

	@Transactional
	@Override
	public Task updateTaskById(long taskId, Task updatedTask) {
		Task existTask = getTaskById(taskId);

		existTask.setTitle(updatedTask.getTitle());
		existTask.setDescription(updatedTask.getDescription());
		existTask.setStatus(updatedTask.getStatus());
		existTask.setPriority(updatedTask.getPriority());

		return taskRepository.save(existTask);
	}

	@Transactional
	@Override
	public void deleteTaskById(long taskId) {
		taskRepository.delete(getTaskById(taskId));
	}

	@Transactional
	@Override
	public void assignTaskToUserById(long taskId, long userId) {
		Task existTask = getTaskById(taskId);
		User existUser = userService.getUserById(userId);

		existTask.setAssignedTo(existUser);

		taskRepository.save(existTask);
	}

	@Transactional
	@Override
	public void changeTaskStatusById(long taskId, TaskStatus newTaskStatus) {
		Task existTask = getTaskById(taskId);

		existTask.setStatus(newTaskStatus);

		taskRepository.save(existTask);
	}
}
