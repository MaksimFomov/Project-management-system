package com.fomov.project.management.system.core.service;

import com.fomov.project.management.system.data.model.Project;
import com.fomov.project.management.system.data.model.User;

import java.util.List;
import java.util.Set;

public interface ProjectService {
	Project createProject(Project newProject);

	List<Project> getAllProjectsCurrentUser(long userId);

	Project getProjectById(long projectId);

	Project updateProjectById(long projectId, Project updatedProject);

	void deleteProjectById(long projectId);

	void addMembersToProjectById(long projectId, Set<User> members);

	void removeMembersFromProjectById(long projectId, Set<User> members);
}
