package com.fomov.project.management.system.core.service.impl;

import com.fomov.project.management.system.core.exception.notfound.CommentNotFoundException;
import com.fomov.project.management.system.core.service.CommentService;
import com.fomov.project.management.system.core.service.TaskService;
import com.fomov.project.management.system.data.model.Comment;
import com.fomov.project.management.system.data.model.Task;
import com.fomov.project.management.system.data.repository.CommentRepository;
import com.fomov.project.management.system.data.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commentRepository;
	private final TaskRepository taskRepository;
	private final TaskService taskService;

	@Transactional
	@Override
	public Comment addCommentToTaskById(long taskId, Comment comment) {
		Task existTask = taskService.getTaskById(taskId);

		existTask.getComments().add(comment);

		taskRepository.save(existTask);

		return comment;
	}

	@Override
	public List<Comment> getAllTaskCommentsById(long taskId) {
		return taskService.getTaskById(taskId)
				.getComments();
	}

	@Transactional
	@Override
	public void deleteCommentById(long commentId) {
		commentRepository.delete(
				commentRepository.findById(commentId)
						.orElseThrow(() -> new CommentNotFoundException("Comment not found with ID: " + commentId))
		);
	}
}
