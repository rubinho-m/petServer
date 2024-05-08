package com.petproject.petserver.services;

import com.petproject.petserver.exceptions.AppException;
import com.petproject.petserver.model.Pet;
import com.petproject.petserver.model.PetType;
import com.petproject.petserver.model.User;
import com.petproject.petserver.model.dto.PetDTO;
import com.petproject.petserver.repositories.PetTypeRepository;
import com.petproject.petserver.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PetMapperService {
    private final PetTypeRepository petTypeRepository;
    private final UserRepository userRepository;
    public Pet dtoToPet(PetDTO petDTO){
        if (petDTO == null) return null;
        return Pet.builder()
                .id(petDTO.getId())
                .user(petDTO.getUser())
                .name(petDTO.getName())
                .type(getPetType(petDTO.getType()))
                .dateOfBirth(petDTO.getDateOfBirth())
                .weight(petDTO.getWeight())
                .imageURI(petDTO.getImageURI())
                .build();
    }

    private PetType getPetType(String typeName){
        return petTypeRepository.findPetTypeByType(typeName)
                .orElseThrow(() -> new AppException("Unknown pet type", HttpStatus.NOT_FOUND));
    }

    private User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
    }

}
