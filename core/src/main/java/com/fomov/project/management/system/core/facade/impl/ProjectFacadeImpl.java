package com.fomov.project.management.system.core.facade.impl;

import com.fomov.project.management.system.core.dto.project.ProjectRequestDTO;
import com.fomov.project.management.system.core.dto.project.ProjectResponseDTO;
import com.fomov.project.management.system.core.dto.user.UserRequestDTO;
import com.fomov.project.management.system.core.facade.ProjectFacade;
import com.fomov.project.management.system.core.mapper.project.ProjectRequestMapper;
import com.fomov.project.management.system.core.mapper.project.ProjectResponseMapper;
import com.fomov.project.management.system.core.mapper.user.UserRequestMapper;
import com.fomov.project.management.system.core.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProjectFacadeImpl implements ProjectFacade {
	private final ProjectService projectService;

	private final ProjectResponseMapper projectResponseMapper;

	private final ProjectRequestMapper projectRequestMapper;

	private final UserRequestMapper userRequestMapper;

	@Override
	public ProjectResponseDTO createProject(ProjectRequestDTO newProjectDTO) {
		return projectResponseMapper.toProjectResponseDTO(
				projectService.createProject(
						projectRequestMapper.toProjectModel(newProjectDTO)
				)
		);
	}

	@Override
	public List<ProjectResponseDTO> getAllProjectsCurrentUser(long userId) {
		return projectResponseMapper.toProjectResponseDTOs(
				projectService.getAllProjectsCurrentUser(userId)
		);
	}

	@Override
	public ProjectResponseDTO getProjectById(long projectId) {
		return projectResponseMapper.toProjectResponseDTO(
				projectService.getProjectById(projectId)
		);
	}

	@Override
	public ProjectResponseDTO updateProjectById(long projectId, ProjectRequestDTO updatedProjectDTO) {
		return projectResponseMapper.toProjectResponseDTO(
				projectService.updateProjectById(
						projectId, projectRequestMapper.toProjectModel(updatedProjectDTO)
				)
		);
	}

	@Override
	public void deleteProjectById(long projectId) {
		projectService.deleteProjectById(projectId);
	}

	@Override
	public void addMembersToProjectById(long projectId, Set<UserRequestDTO> memberDTOs) {
		projectService.addMembersToProjectById(
				projectId, userRequestMapper.toUserModels(memberDTOs)
		);
	}

	@Override
	public void deleteMembersFromProjectById(long projectId, Set<UserRequestDTO> memberDTOs) {
		projectService.deleteMembersFromProjectById(
				projectId, userRequestMapper.toUserModels(memberDTOs)
		);
	}
}
