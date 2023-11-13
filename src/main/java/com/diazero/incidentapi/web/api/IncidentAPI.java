package com.diazero.incidentapi.web.api;

import com.diazero.incidentapi.dto.IncidentDTO;
import com.diazero.incidentapi.web.request.incident.IncidentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@Tag(name = "Incidents")
@RequestMapping(value = "/v1")
public interface IncidentAPI {

    @GetMapping(
            path = "/incident/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Returns incident by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Incident returned successfully."),
            @ApiResponse(responseCode = "404", description = "Incident not found in database."),
            @ApiResponse(responseCode = "400", description = "Invalid parameters, check out your request."),
            @ApiResponse(responseCode = "500", description = "An internal error was thrown.")
    })
    ResponseEntity<IncidentDTO> retrieveIncidentById(@PathVariable Long id);

    @GetMapping(
            path = "/incident",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Returns all incidents registered in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All incidents were returned successfully."),
            @ApiResponse(responseCode = "500", description = "An internal error was thrown.")
    })
    ResponseEntity<List<IncidentDTO>> retrieveAllIncidents();

    @PostMapping(
            path = "/incident",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Adds an Incident on database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Incident created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid parameters, check out your request."),
            @ApiResponse(responseCode = "500", description = "An internal error was thrown.")
    })
    ResponseEntity<IncidentDTO> addPerson(@RequestBody IncidentRequest personRequest) throws URISyntaxException;

    @DeleteMapping(
            path = "/incident/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Deletes an incident by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Incident deleted successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid parameters, check out your request."),
            @ApiResponse(responseCode = "500", description = "An internal error was thrown.")
    })
    ResponseEntity<Void> deleteIncident(@PathVariable Long id);
}