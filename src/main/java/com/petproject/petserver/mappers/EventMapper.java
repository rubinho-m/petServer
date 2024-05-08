package com.petproject.petserver.mappers;

import com.petproject.petserver.model.Event;
import com.petproject.petserver.model.dto.EventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDTO toEventDTO(Event event);
}
