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
@Table(name = "notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "content", nullable = false)
	private String content;

	@ManyToOne
	private User recipientId;

	@Column(name = "read")
	private boolean read;

	@Column(name = "created_at")
	private Date createdAt;
}
