package com.fomov.project.management.system.core.dto.comment;

import com.fomov.project.management.system.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDTO {
	private String content;

	private User authorId;

	private LocalDateTime createdAt;
}
