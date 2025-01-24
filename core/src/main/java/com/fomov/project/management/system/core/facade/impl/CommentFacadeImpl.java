package com.fomov.project.management.system.core.facade.impl;

import com.fomov.project.management.system.core.dto.comment.CommentRequestDTO;
import com.fomov.project.management.system.core.dto.comment.CommentResponseDTO;
import com.fomov.project.management.system.core.facade.CommentFacade;
import com.fomov.project.management.system.core.mapper.comment.CommentRequestMapper;
import com.fomov.project.management.system.core.mapper.comment.CommentResponseMapper;
import com.fomov.project.management.system.core.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentFacadeImpl implements CommentFacade {
	private final CommentService commentService;

	private final CommentResponseMapper commentResponseMapper;

	private final CommentRequestMapper commentRequestMapper;

	@Override
	public CommentResponseDTO addCommentToTaskById(long taskId, CommentRequestDTO commentRequestDTO) {
		return commentResponseMapper.toCommentResponseDTO(
				commentService.addCommentToTaskById(
						taskId, commentRequestMapper.toCommentModel(commentRequestDTO)
				)
		);
	}

	@Override
	public List<CommentResponseDTO> getAllTaskCommentsById(long taskId) {
		return commentResponseMapper.toCommentResponseDTOs(
				commentService.getAllTaskCommentsById(taskId)
		);
	}

	@Override
	public void deleteCommentById(long commentId) {
		commentService.deleteCommentById(commentId);
	}
}
