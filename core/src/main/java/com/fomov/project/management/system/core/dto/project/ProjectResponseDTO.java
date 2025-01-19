package com.fomov.project.management.system.core.dto.project;

import com.fomov.project.management.system.data.enums.ProjectStatus;
import com.fomov.project.management.system.data.model.Task;
import com.fomov.project.management.system.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDTO {
	private String name;

	private String description;

	private User owner;

	private List<Task> tasks = new ArrayList<>();

	private Set<User> team = new HashSet<>();

	private ProjectStatus status;
}
