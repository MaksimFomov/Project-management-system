package com.fomov.project.management.system.core.mapper.comment;

import com.fomov.project.management.system.core.dto.comment.CommentRequestDTO;
import com.fomov.project.management.system.data.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentRequestMapper {
	Comment toCommentModel(CommentRequestDTO commentRequestDTO);
}
