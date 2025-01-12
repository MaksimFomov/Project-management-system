package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.service.ProjectService;
import com.fomov.project.management.system.data.model.Project;
import com.fomov.project.management.system.data.model.User;
import com.fomov.project.management.system.data.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {
	private final ProjectRepository projectRepository;

	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Transactional
	@Override
	public Project createProject(Project newProject) {
		return projectRepository.save(newProject);
	}

	//Доработать
	@Override
	public List<Project> getAllProjectsCurrentUser(long userId) {
		return null;
	}


	@Override
	public Project getProjectById(long projectId) {
		return projectRepository.findById(projectId)
				.orElseThrow();
	}

	//доработать
	@Transactional
	@Override
	public Project updateProjectById(long projectId, Project updatedProject) {
		Project existingProject = projectRepository.findById(projectId)
				.orElseThrow();

		existingProject.setName(updatedProject.getName());
		existingProject.setDescription(updatedProject.getDescription());
		existingProject.setStatus(updatedProject.getStatus());

		return projectRepository.save(existingProject);
	}

	@Transactional
	@Override
	public void deleteProjectById(long projectId) {
		projectRepository.delete(
				projectRepository.findById(projectId)
						.orElseThrow()
		);
	}

	@Transactional
	@Override
	public void addMembersToProjectById(long projectId, Set<User> members) {
		Project existingProject = projectRepository.findById(projectId)
				.orElseThrow();

		if (members == null || members.isEmpty()) {
			return;
		}

		existingProject.getTeam().addAll(members);

		projectRepository.save(existingProject);
	}

	@Transactional
	@Override
	public void deleteMembersFromProjectById(long projectId, Set<User> members) {
		Project existingProject = projectRepository.findById(projectId)
				.orElseThrow();

		if (members == null || members.isEmpty()) {
			return;
		}

		existingProject.getTeam().removeAll(members);

		projectRepository.save(existingProject);
	}
}
