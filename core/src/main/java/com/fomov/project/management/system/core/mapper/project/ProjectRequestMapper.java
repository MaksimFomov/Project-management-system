package com.fomov.project.management.system.core.mapper.project;

import com.fomov.project.management.system.core.dto.project.ProjectRequestDTO;
import com.fomov.project.management.system.data.model.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectRequestMapper {
	Project toProjectModel(ProjectRequestDTO projectRequestDTO);
}
