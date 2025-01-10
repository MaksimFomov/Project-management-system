package com.fomov.project.management.system.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "content", nullable = false)
	private String content;

	@ManyToOne
	private Task taskId;

	@ManyToOne
	private User authorId;

	@Column(name = "created_at")
	private Date createdAt;
}
