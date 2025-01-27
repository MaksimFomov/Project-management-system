package com.fomov.project.management.system.web.controller;

import com.fomov.project.management.system.core.dto.project.ProjectRequestDTO;
import com.fomov.project.management.system.core.dto.project.ProjectResponseDTO;
import com.fomov.project.management.system.core.dto.user.UserRequestDTO;
import com.fomov.project.management.system.core.exception.notfound.ProjectNotFoundException;
import com.fomov.project.management.system.core.facade.ProjectFacade;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
	private final ProjectFacade projectFacade;

	@PostMapping
	public ResponseEntity<?> createProject(@Valid @RequestBody ProjectRequestDTO projectRequestDTO) {
		try {
			ProjectResponseDTO projectResponseDTO = projectFacade.createProject(projectRequestDTO);

			return ResponseEntity.status(HttpStatus.OK).body(projectResponseDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	//check
	@GetMapping
	public ResponseEntity<?> getAllProjectsCurrentUser() {
		try {
			long userId = 0;
			List<ProjectResponseDTO> projectResponseDTOs = projectFacade.getAllProjectsCurrentUser(userId);

			return ResponseEntity.status(HttpStatus.OK).body(projectResponseDTOs);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable long projectId) {
		try {
			ProjectResponseDTO projectResponseDTO = projectFacade.getProjectById(projectId);

			return ResponseEntity.status(HttpStatus.OK).body(projectResponseDTO);
		} catch (ProjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/{projectId}")
	public ResponseEntity<?> updateProjectById(@PathVariable long projectId, @Valid @RequestBody ProjectRequestDTO projectRequestDTO) {
		try {
			ProjectResponseDTO projectResponseDTO = projectFacade.updateProjectById(projectId, projectRequestDTO);

			return ResponseEntity.status(HttpStatus.OK).body(projectResponseDTO);
		} catch (ProjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProjectById(@PathVariable long projectId) {
		try {
			projectFacade.deleteProjectById(projectId);

			return ResponseEntity.status(HttpStatus.OK).body("Project successfully deleted.");
		} catch (ProjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	//check
	@PostMapping("/{projectId}/add-member")
	public ResponseEntity<?> addMembersToProjectById(@PathVariable long projectId, @RequestBody Set<UserRequestDTO> users) {
		try {
			projectFacade.addMembersToProjectById(projectId, users);

			return ResponseEntity.status(HttpStatus.OK).body("Users have been successfully added to the project.");
		} catch (ProjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	//check
	@PostMapping("/{projectId}/remove-member")
	public ResponseEntity<?> removeMembersToProjectById(@PathVariable long projectId, @RequestBody Set<UserRequestDTO> users) {
		try {
			projectFacade.removeMembersFromProjectById(projectId, users);

			return ResponseEntity.status(HttpStatus.OK).body("Users have been successfully removed from the project.");
		} catch (ProjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
