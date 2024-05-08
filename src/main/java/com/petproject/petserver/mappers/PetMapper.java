package com.petproject.petserver.mappers;

import com.petproject.petserver.model.Pet;
import com.petproject.petserver.model.dto.PetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(source = "type.type", target = "type")
    PetDTO toPetDTO(Pet pet);
}
