package com.fomov.project.management.system.core.service;

import com.fomov.project.management.system.data.model.Comment;

import java.util.List;

public interface CommentService {
	Comment addCommentToTaskById(long taskId, Comment comment);

	List<Comment> getAllTaskCommentsById(long taskId);

	void deleteCommentById(long commentId);
}
