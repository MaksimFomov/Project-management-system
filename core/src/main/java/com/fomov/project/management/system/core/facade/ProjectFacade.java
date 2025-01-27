package com.fomov.project.management.system.core.facade;

import com.fomov.project.management.system.core.dto.project.ProjectRequestDTO;
import com.fomov.project.management.system.core.dto.project.ProjectResponseDTO;
import com.fomov.project.management.system.core.dto.user.UserRequestDTO;

import java.util.List;
import java.util.Set;

public interface ProjectFacade {
	ProjectResponseDTO createProject(ProjectRequestDTO newProjectDTO);

	List<ProjectResponseDTO> getAllProjectsCurrentUser(long userId);

	ProjectResponseDTO getProjectById(long projectId);

	ProjectResponseDTO updateProjectById(long projectId, ProjectRequestDTO updatedProjectDTO);

	void deleteProjectById(long projectId);

	void addMembersToProjectById(long projectId, Set<UserRequestDTO> memberDTOs);

	void removeMembersFromProjectById(long projectId, Set<UserRequestDTO> memberDTOs);
}
