package com.fomov.project.management.system.core.dto.project;

import com.fomov.project.management.system.data.enums.ProjectStatus;
import com.fomov.project.management.system.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDTO {
	private String name;

	private String description;

	private User owner;

	private ProjectStatus status;
}
