package com.fomov.project.management.system.core.service;

import com.fomov.project.management.system.data.enums.TaskStatus;
import com.fomov.project.management.system.data.model.Task;

import java.util.List;

public interface TaskService {
	Task createTaskInProjectById(long projectId, Task newTask);

	List<Task> getAllProjectTasksById(long projectId);

	Task getTaskById(long taskId);

	Task updateTaskById(long taskId, Task updatedTask);

	void deleteTaskById(long taskId);

	void assignTaskToUserById(long taskId, long userId);

	void changeTaskStatusById(long taskId, TaskStatus newTaskStatus);
}
