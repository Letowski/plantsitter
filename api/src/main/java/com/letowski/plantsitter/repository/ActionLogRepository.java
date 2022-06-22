package com.letowski.plantsitter.repository;

import com.letowski.plantsitter.entity.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActionLogRepository extends JpaRepository<ActionLog, UUID> {

    List<ActionLog> findAll();
    List<ActionLog> findAllByCreatedAtAfterOrderByCreatedAtDesc(LocalDateTime createdAt);

    Optional<ActionLog> findFirstByTypeInOrderByCreatedAtDesc(List<String> types);
}
