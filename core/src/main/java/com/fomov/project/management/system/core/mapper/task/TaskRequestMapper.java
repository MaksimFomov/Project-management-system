package com.fomov.project.management.system.core.mapper.task;

import com.fomov.project.management.system.core.dto.task.TaskRequestDTO;
import com.fomov.project.management.system.data.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskRequestMapper {
	Task toTaskModel(TaskRequestDTO taskRequestDTO);
}
