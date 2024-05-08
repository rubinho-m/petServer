package com.petproject.petserver.services;

import com.petproject.petserver.exceptions.AppException;
import com.petproject.petserver.model.PetType;
import com.petproject.petserver.repositories.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public List<PetType> getAllPetTypes(){
        return petTypeRepository.findAll();
    }

    public PetType getPetTypeByID(Long id){
        return petTypeRepository.findById(id)
                .orElseThrow(() -> new AppException("The PetType with this id doesn't exist", HttpStatus.NOT_FOUND));

    }

    public PetType savePetType(PetType petType){
        return petTypeRepository.save(petType);
    }

    public void delete(Long id){
        petTypeRepository.deleteById(id);
    }
}
