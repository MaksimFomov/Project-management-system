package com.fomov.project.management.system.web.controller;

import com.fomov.project.management.system.core.dto.comment.CommentRequestDTO;
import com.fomov.project.management.system.core.dto.comment.CommentResponseDTO;
import com.fomov.project.management.system.core.exception.notfound.CommentNotFoundException;
import com.fomov.project.management.system.core.exception.notfound.TaskNotFoundException;
import com.fomov.project.management.system.core.facade.CommentFacade;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CommentController {
	private final CommentFacade commentFacade;

	@PostMapping("/tasks/{taskId}/comments")
	public ResponseEntity<?> addCommentToTaskById(@PathVariable long taskId, @Valid @RequestBody CommentRequestDTO commentRequestDTO) {
		try {
			CommentResponseDTO commentResponseDTO = commentFacade.addCommentToTaskById(taskId, commentRequestDTO);

			return ResponseEntity.status(HttpStatus.OK).body(commentResponseDTO);
		} catch (TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/tasks/{taskId}/comments")
	public ResponseEntity<?> getAllTaskCommentsById(@PathVariable long taskId) {
		try {
			List<CommentResponseDTO> commentResponseDTOs = commentFacade.getAllTaskCommentsById(taskId);

			return ResponseEntity.status(HttpStatus.OK).body(commentResponseDTOs);
		} catch (TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<?> deleteCommentById(@PathVariable long commentId) {
		try {
			commentFacade.deleteCommentById(commentId);

			return ResponseEntity.status(HttpStatus.OK).body("Comment successfully deleted.");
		} catch (CommentNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
