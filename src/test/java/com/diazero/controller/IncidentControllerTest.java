package com.diazero.controller;


import com.diazero.incidentapi.dto.IncidentDTO;
import com.diazero.incidentapi.service.IncidentService;
import com.diazero.incidentapi.web.controller.IncidentController;
import com.diazero.incidentapi.web.request.incident.IncidentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IncidentControllerTest {

    @Mock
    private IncidentService incidentService;

    @InjectMocks
    private IncidentController incidentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void retrieveIncidentById_shouldReturnIncidentDTO() {
        // Arrange
        Long incidentId = 1L;
        IncidentDTO mockIncidentDTO = new IncidentDTO(); // You should set appropriate values
        when(incidentService.retrieveIncidentById(incidentId)).thenReturn(mockIncidentDTO);

        // Act
        ResponseEntity<IncidentDTO> response = incidentController.retrieveIncidentById(incidentId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockIncidentDTO, response.getBody());
    }

    @Test
    void retrieveAllIncidents_shouldReturnListOfIncidentDTO() {
        // Arrange
        List<IncidentDTO> mockIncidents = Arrays.asList(new IncidentDTO(), new IncidentDTO()); // Set appropriate values
        when(incidentService.retrieveAllIncidents()).thenReturn(mockIncidents);

        // Act
        ResponseEntity<List<IncidentDTO>> response = incidentController.retrieveAllIncidents();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockIncidents, response.getBody());
    }

    // Add similar tests for other controller methods...

    @Test
    void addIncident_shouldReturnCreatedStatus() throws URISyntaxException {
        // Arrange
        IncidentRequest mockIncidentRequest = new IncidentRequest(); // Set appropriate values
        IncidentDTO mockCreatedIncident = new IncidentDTO(); // Set appropriate values
        when(incidentService.addIncident(mockIncidentRequest)).thenReturn(mockCreatedIncident);

        // Act
        ResponseEntity<IncidentDTO> response = incidentController.addIncident(mockIncidentRequest);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockCreatedIncident, response.getBody());
        assertEquals(new URI("/v1/incident"), response.getHeaders().getLocation());
    }
}
