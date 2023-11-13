package com.diazero.incidentapi.domain.repository;

import com.diazero.incidentapi.domain.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {
    @Query(value = "SELECT * FROM incident ORDER BY created_at DESC LIMIT 20", nativeQuery = true)
    Optional<List<IncidentEntity>> findLast20ByCreatedAtDesc();
}