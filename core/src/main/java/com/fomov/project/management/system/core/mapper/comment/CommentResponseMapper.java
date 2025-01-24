package com.fomov.project.management.system.core.mapper.comment;

import com.fomov.project.management.system.core.dto.comment.CommentResponseDTO;
import com.fomov.project.management.system.data.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentResponseMapper {
	CommentResponseDTO toCommentResponseDTO(Comment comment);

	List<CommentResponseDTO> toCommentResponseDTOs(List<Comment> comments);
}
