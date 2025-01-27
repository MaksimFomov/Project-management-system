package com.fomov.project.management.system.web.controller;

import com.fomov.project.management.system.core.dto.task.TaskRequestDTO;
import com.fomov.project.management.system.core.dto.task.TaskResponseDTO;
import com.fomov.project.management.system.core.exception.notfound.ProjectNotFoundException;
import com.fomov.project.management.system.core.exception.notfound.TaskNotFoundException;
import com.fomov.project.management.system.core.exception.notfound.UserNotFoundException;
import com.fomov.project.management.system.core.facade.TaskFacade;
import com.fomov.project.management.system.data.enums.TaskStatus;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TaskController {
	private final TaskFacade taskFacade;

	@PostMapping("/projects/{projectId}/tasks")
	public ResponseEntity<?> createTaskInProjectById(@PathVariable long projectId, @Valid @RequestBody TaskRequestDTO taskRequestDTO) {
		try {
			TaskResponseDTO taskResponseDTO = taskFacade.createTaskInProjectById(projectId, taskRequestDTO);

			return ResponseEntity.status(HttpStatus.OK).body(taskResponseDTO);
		} catch (ProjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/projects/{projectId}/tasks")
	public ResponseEntity<?> getAllProjectTasksById(@PathVariable long projectId) {
		try {
			List<TaskResponseDTO> taskResponseDTOs = taskFacade.getAllProjectTasksById(projectId);

			return ResponseEntity.status(HttpStatus.OK).body(taskResponseDTOs);
		} catch (ProjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/tasks/{taskId}")
	public ResponseEntity<?> getTaskById(@PathVariable long taskId) {
		try {
			TaskResponseDTO taskResponseDTO = taskFacade.getTaskById(taskId);

			return ResponseEntity.status(HttpStatus.OK).body(taskResponseDTO);
		} catch (TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping("/tasks/{taskId}")
	public ResponseEntity<?> updateTaskById(@PathVariable long taskId, @Valid @RequestBody TaskRequestDTO taskRequestDTO) {
		try {
			TaskResponseDTO taskResponseDTO = taskFacade.updateTaskById(taskId, taskRequestDTO);

			return ResponseEntity.status(HttpStatus.OK).body(taskResponseDTO);
		} catch (TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/tasks/{taskId}")
	public ResponseEntity<?> deleteTaskById(@PathVariable long taskId) {
		try {
			taskFacade.deleteTaskById(taskId);

			return ResponseEntity.status(HttpStatus.OK).body("Task successfully deleted.");
		} catch (TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping(value = "/tasks/{taskId}/assign", params = "userId")
	public ResponseEntity<?> assignTaskToUserById(@PathVariable long taskId, @RequestParam long userId) {
		try {
			taskFacade.assignTaskToUserById(taskId, userId);

			return ResponseEntity.status(HttpStatus.OK).body("The user has been successfully assigned a task.");
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping(value = "/tasks/{taskId}/change-status", params = "taskStatus")
	public ResponseEntity<?> changeTaskStatusById(@PathVariable long taskId, @RequestParam TaskStatus taskStatus) {
		try {
			taskFacade.changeTaskStatusById(taskId, taskStatus);

			return ResponseEntity.status(HttpStatus.OK).body("Task status changed successfully.");
		} catch (TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
