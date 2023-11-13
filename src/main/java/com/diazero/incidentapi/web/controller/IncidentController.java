package com.diazero.incidentapi.web.controller;

import com.diazero.incidentapi.dto.IncidentDTO;
import com.diazero.incidentapi.service.IncidentService;
import com.diazero.incidentapi.web.api.IncidentAPI;
import com.diazero.incidentapi.web.request.incident.IncidentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequiredArgsConstructor
public class IncidentController implements IncidentAPI {

    private final IncidentService incidentService;

    @Override
    public ResponseEntity<IncidentDTO> retrieveIncidentById(Long id) {
       return ResponseEntity.ok(incidentService.retrieveIncidentById(id));
    }

    @Override
    public ResponseEntity<List<IncidentDTO>> retrieveAllIncidents() {
        return ResponseEntity.ok(incidentService.retrieveAllIncidents());
    }

    @Override
    public ResponseEntity<IncidentDTO> addIncident(IncidentRequest incidentRequest) throws URISyntaxException {
        IncidentDTO createdIncident = incidentService.addIncident(incidentRequest);
        String resourceUrl = "/v1/incident";
        return ResponseEntity.created(new URI(resourceUrl)).body(createdIncident);
    }

    @Override
    public ResponseEntity<IncidentDTO> updateIncident(Long id, IncidentRequest incidentRequest) {
        return ResponseEntity.ok(incidentService.updateIncident(id, incidentRequest));
    }

    @Override
    public ResponseEntity<Void> deleteIncident(Long id) {
        incidentService.deleteIncident(id);
        return ResponseEntity.noContent().build();
    }
}
