package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.service.CommentService;
import com.fomov.project.management.system.data.model.Comment;
import com.fomov.project.management.system.data.repository.CommentRepository;
import com.fomov.project.management.system.data.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commentRepository;
	private final TaskRepository taskRepository;

	public CommentServiceImpl(CommentRepository commentRepository, TaskRepository taskRepository) {
		this.commentRepository = commentRepository;
		this.taskRepository = taskRepository;
	}

	@Transactional
	@Override
	public Comment addCommentToTaskById(long taskId, Comment comment) {
		comment.setTask(
				taskRepository.findById(taskId)
						.orElseThrow()
		);

		return commentRepository.save(comment);
	}

	@Override
	public List<Comment> getAllTaskCommentsById(long taskId) {
		return commentRepository.findByTask(
				taskRepository.findById(taskId)
						.orElseThrow()
		);
	}

	@Transactional
	@Override
	public void deleteCommentById(long commentId) {
		commentRepository.delete(
				commentRepository.findById(commentId)
						.orElseThrow()
		);
	}
}
