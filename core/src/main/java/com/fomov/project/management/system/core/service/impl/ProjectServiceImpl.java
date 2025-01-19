package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.exception.notfound.ProjectNotFoundException;
import com.fomov.project.management.system.core.service.ProjectService;
import com.fomov.project.management.system.data.model.Project;
import com.fomov.project.management.system.data.model.User;
import com.fomov.project.management.system.data.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
	private final ProjectRepository projectRepository;

	@Transactional
	@Override
	public Project createProject(Project newProject) {
		return projectRepository.save(newProject);
	}

	@Override
	public List<Project> getAllProjectsCurrentUser(long userId) {
		return projectRepository.findAllProjectsByUserId(userId);
	}

	@Override
	public Project getProjectById(long projectId) {
		return projectRepository.findById(projectId)
				.orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + projectId));
	}

	@Transactional
	@Override
	public Project updateProjectById(long projectId, Project updatedProject) {
		Project existingProject = getProjectById(projectId);

		existingProject.setName(updatedProject.getName());
		existingProject.setDescription(updatedProject.getDescription());
		existingProject.setStatus(updatedProject.getStatus());

		return projectRepository.save(existingProject);
	}

	@Transactional
	@Override
	public void deleteProjectById(long projectId) {
		projectRepository.delete(getProjectById(projectId));
	}

	@Transactional
	@Override
	public void addMembersToProjectById(long projectId, Set<User> members) {
		Project existingProject = getProjectById(projectId);

		if (members == null || members.isEmpty()) {
			return;
		}

		existingProject.getTeam().addAll(members);

		projectRepository.save(existingProject);
	}

	@Transactional
	@Override
	public void deleteMembersFromProjectById(long projectId, Set<User> members) {
		Project existingProject = getProjectById(projectId);

		if (members == null || members.isEmpty()) {
			return;
		}

		existingProject.getTeam().removeAll(members);

		projectRepository.save(existingProject);
	}
}
