package com.fomov.project.management.system.data.repository;

import com.fomov.project.management.system.data.model.Comment;
import com.fomov.project.management.system.data.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByTask(Task task);
}
