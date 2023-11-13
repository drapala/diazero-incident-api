package com.diazero.incidentapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncidentDTO {
    private Long idIncident;

    private String name;

    private String description;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant closedAt;
}