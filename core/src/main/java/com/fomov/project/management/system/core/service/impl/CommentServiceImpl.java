package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.service.CommentService;
import com.fomov.project.management.system.data.model.Comment;
import com.fomov.project.management.system.data.model.Task;
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
		Task existTask = taskRepository.findById(taskId)
				.orElseThrow();

		existTask.getComments().add(comment);
		taskRepository.save(existTask);

		return comment;
	}

	@Override
	public List<Comment> getAllTaskCommentsById(long taskId) {
		return taskRepository.findById(taskId)
				.orElseThrow()
				.getComments();
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
