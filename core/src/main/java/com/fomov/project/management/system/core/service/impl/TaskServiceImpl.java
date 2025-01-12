package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.service.TaskService;
import com.fomov.project.management.system.data.enums.TaskStatus;
import com.fomov.project.management.system.data.model.Task;
import com.fomov.project.management.system.data.model.User;
import com.fomov.project.management.system.data.repository.TaskRepository;
import com.fomov.project.management.system.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
	private final TaskRepository taskRepository;
	private final UserRepository userRepository;

	public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
		this.taskRepository = taskRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	@Override
	public Task createTask(Task newTask) {
		return taskRepository.save(newTask);
	}

	//доработать
	@Override
	public List<Task> getAllProjectTasks() {
		return null;
	}

	@Override
	public Task getTaskById(long taskId) {
		return taskRepository.findById(taskId)
				.orElseThrow();
	}

	//доработать
	@Transactional
	@Override
	public Task updateTaskById(long taskId, Task updatedTask) {
		Task existTask = taskRepository.findById(taskId)
				.orElseThrow();

		existTask.setTitle(updatedTask.getTitle());
		existTask.setDescription(updatedTask.getDescription());

		return taskRepository.save(existTask);
	}

	@Transactional
	@Override
	public void deleteTaskById(long taskId) {
		taskRepository.delete(
				taskRepository.findById(taskId)
						.orElseThrow()
		);
	}

	@Transactional
	@Override
	public void assignTaskToUserById(long taskId, long userId) {
		Task existTask = taskRepository.findById(taskId)
				.orElseThrow();
		User existUser = userRepository.findById(userId)
				.orElseThrow();

		existTask.setAssignedTo(existUser);

		taskRepository.save(existTask);
	}

	@Transactional
	@Override
	public void changeTaskStatusById(long taskId, TaskStatus newTaskStatus) {
		Task existTask = taskRepository.findById(taskId)
				.orElseThrow();

		existTask.setStatus(newTaskStatus);

		taskRepository.save(existTask);
	}
}
