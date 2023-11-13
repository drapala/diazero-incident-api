package com.diazero.incidentapi.web.controller;

import com.diazero.incidentapi.dto.IncidentDTO;
import com.diazero.incidentapi.service.IncidentService;
import com.diazero.incidentapi.web.api.IncidentAPI;
import com.diazero.incidentapi.web.request.incident.IncidentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class IncidentController implements IncidentAPI {

    private final IncidentService incidentService;


    public ResponseEntity<IncidentDTO> retrieveIncidentById(@PathVariable Long id) {
        return ResponseEntity.ok(incidentService.retrieveIncidentById(id));
    }

    public ResponseEntity<List<IncidentDTO>> retrieveAllIncidents() {
        return ResponseEntity.ok(incidentService.retrieveAllIncidents());
    }

    public ResponseEntity<IncidentDTO> addPerson(@RequestBody IncidentRequest incidentRequest) throws URISyntaxException {
        IncidentDTO createdPerson = incidentService.addIncident(incidentRequest);

        String resourceUrl = "/v1/incident";

        return ResponseEntity.created(new URI(resourceUrl)).body(createdIncident);
    }

    public ResponseEntity<IncidentDTO> updateIncident(
            @PathVariable Long id,
            @RequestBody IncidentRequest incidentRequest) {
        return ResponseEntity.ok(incidentService.updateIncident(id, incidentRequest));
    }

    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
        return ResponseEntity.noContent().build();
    }
}
