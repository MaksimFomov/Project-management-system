package com.fomov.project.management.system.core.facade;

import com.fomov.project.management.system.core.dto.comment.CommentRequestDTO;
import com.fomov.project.management.system.core.dto.comment.CommentResponseDTO;
import com.fomov.project.management.system.data.model.Comment;

import java.util.List;

public interface CommentFacade {
	CommentResponseDTO addCommentToTaskById(long taskId, CommentRequestDTO commentRequestDTO);

	List<CommentResponseDTO> getAllTaskCommentsById(long taskId);

	void deleteCommentById(long commentId);
}
