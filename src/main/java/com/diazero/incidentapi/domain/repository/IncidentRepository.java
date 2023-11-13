package com.diazero.incidentapi.domain.repository;

import com.diazero.incidentapi.domain.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {

    IncidentEntity findByName(String incidentName);

    List<IncidentEntity> findByInitialDateBetween(Instant startDate, Instant endDate);

    List<IncidentEntity> findByFinalDateBetween(Instant startDate, Instant endDate);

    List<IncidentEntity> findByObservation(String keyword);
}