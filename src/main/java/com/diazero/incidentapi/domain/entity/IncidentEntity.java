package com.diazero.incidentapi.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "incident")
@Entity(name = "Incident")
@ToString(exclude = {"id"})
public class IncidentEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_incident", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name_incident", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "closed_at", nullable = false)
    private Instant closedAt;
}