package com.diazero.incidentapi.web.controller;

import com.diazero.incidentapi.dto.IncidentDTO;
import com.diazero.incidentapi.service.IncidentService;
import com.diazero.incidentapi.web.api.IncidentAPI;
import com.diazero.incidentapi.web.request.incident.IncidentRequest;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class IncidentController implements IncidentAPI {

    private final IncidentService incidentService;

    @Override
    public ResponseEntity<IncidentDTO> retrieveIncidentById(@NotNull  Long id) {
       return ResponseEntity.ok(incidentService.retrieveIncidentById(id));
    }

    @Override
    public ResponseEntity<List<IncidentDTO>> retrieveAllIncidents() {
        return ResponseEntity.ok(incidentService.retrieveAllIncidents());
    }

    @Override
    public ResponseEntity<IncidentDTO> addIncident(@NotNull IncidentRequest incidentRequest) throws URISyntaxException {
        IncidentDTO createdIncident = incidentService.addIncident(incidentRequest);
        String resourceUrl = "/v1/incident";
        return ResponseEntity.created(new URI(resourceUrl)).body(createdIncident);
    }

    @Override
    public ResponseEntity<IncidentDTO> updateIncident(@NotNull Long id, @NotNull IncidentRequest incidentRequest) {
        return ResponseEntity.ok(incidentService.updateIncident(id, incidentRequest));
    }

    @Override
    public ResponseEntity<Void> deleteIncident(@NotNull Long id) {
        incidentService.deleteIncident(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<IncidentDTO>> retrieveLast20Incidents() {
        return ResponseEntity.ok(incidentService.retrieveLast20Incidents());
    }
}
