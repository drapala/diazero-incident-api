package com.diazero.incidentapi.web.request.incident;

import lombok.Data;

import java.time.Instant;

@Data
public class IncidentRequest {
    private String name;

    private String description;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant closedAt;
}
