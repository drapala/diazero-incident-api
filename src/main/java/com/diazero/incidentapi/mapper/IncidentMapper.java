package com.diazero.incidentapi.mapper;

import com.diazero.incidentapi.domain.entity.IncidentEntity;
import com.diazero.incidentapi.dto.IncidentDTO;
import com.diazero.incidentapi.web.request.incident.IncidentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class IncidentMapper {

    public abstract IncidentDTO toDTO(IncidentEntity entity);

    public abstract IncidentEntity toEntity(IncidentDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract IncidentEntity toEntity(IncidentRequest incidentRequest);
}