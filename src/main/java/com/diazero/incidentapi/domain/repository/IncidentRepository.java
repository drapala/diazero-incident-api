package com.diazero.incidentapi.domain.repository;

import com.diazero.incidentapi.domain.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {

//    Optional<IncidentEntity> findByName(String incidentName);
//
//    Optional<List<IncidentEntity>> findByInitialDateBetween(Instant startDate, Instant endDate);
//
//    Optional<List<IncidentEntity>> findByFinalDateBetween(Instant startDate, Instant endDate);
//
//    Optional<List<IncidentEntity>> findByObservation(String keyword);
}