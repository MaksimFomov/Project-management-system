package com.fomov.project.management.system.core.mapper.project;

import com.fomov.project.management.system.core.dto.project.ProjectResponseDTO;
import com.fomov.project.management.system.data.model.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectResponseMapper {
	ProjectResponseDTO toProjectResponseDTO(Project project);

	List<ProjectResponseDTO> toProjectResponseDTOs(List<Project> projects);
}
