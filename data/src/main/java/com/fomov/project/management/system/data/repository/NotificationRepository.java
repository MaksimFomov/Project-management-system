package com.fomov.project.management.system.data.repository;

import com.fomov.project.management.system.data.model.Notification;
import com.fomov.project.management.system.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByRecipient(User recipient);
}
