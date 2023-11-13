package com.diazero.incidentapi.service;

import com.diazero.incidentapi.domain.entity.IncidentEntity;
import com.diazero.incidentapi.dto.IncidentDTO;
import com.diazero.incidentapi.domain.repository.IncidentRepository;
import com.diazero.incidentapi.exception.IncidentNotFoundException;
import com.diazero.incidentapi.mapper.IncidentMapper;
import com.diazero.incidentapi.web.request.incident.IncidentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;

    private final IncidentMapper incidentMapper;

    public List<IncidentDTO> retrieveLast20Incidents() {
        return incidentRepository.findLast20ByCreatedAtDesc()
                .orElseThrow()
                .stream()
                .map(incidentMapper::toDTO)
                .toList();
    }

    public IncidentDTO retrieveIncidentById(Long id) {
        Optional<IncidentEntity> incidentEntity = incidentRepository.findById(id);

        if (incidentEntity.isEmpty()) {
            throw new IncidentNotFoundException();
        }

        IncidentEntity incidentInfo = incidentEntity.get();
        return incidentMapper.toDTO(incidentInfo);
    }

    public List<IncidentDTO> retrieveAllIncidents() {
        return incidentRepository.findAll()
                .stream()
                .map(incidentMapper::toDTO)
                .toList();
    }

    public IncidentDTO addIncident(IncidentRequest incidentRequest) {
        IncidentEntity incidentEntity = incidentMapper.toEntity(incidentRequest);
        IncidentEntity savedIncident = incidentRepository.save(incidentEntity);
        return incidentMapper.toDTO(savedIncident);
    }

    public IncidentDTO updateIncident(Long id, IncidentRequest incidentRequest) {
        Optional<IncidentEntity> incidentEntity = incidentRepository.findById(id);

        if (incidentEntity.isEmpty()) {
            throw new IncidentNotFoundException();
        }

        incidentEntity.get().setName(incidentRequest.getName());

        return incidentMapper.toDTO(incidentRepository.save(incidentEntity.get()));
    }

    public void deleteIncident(Long id) {
        Optional<IncidentEntity> incidentEntity = incidentRepository.findById(id);

        if (incidentEntity.isEmpty()) {
            throw new IncidentNotFoundException();
        }

        incidentRepository.delete(incidentEntity.get());
    }
}