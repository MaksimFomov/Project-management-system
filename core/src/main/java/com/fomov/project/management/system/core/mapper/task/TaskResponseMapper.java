package com.fomov.project.management.system.core.mapper.task;

import com.fomov.project.management.system.core.dto.task.TaskResponseDTO;
import com.fomov.project.management.system.data.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskResponseMapper {
	TaskResponseDTO toTaskResponseDTO(Task task);

	List<TaskResponseDTO> toTaskResponseDTOs(List<Task> tasks);
}
