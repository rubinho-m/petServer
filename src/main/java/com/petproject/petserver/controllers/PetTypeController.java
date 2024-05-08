package com.petproject.petserver.controllers;

import com.petproject.petserver.model.PetType;
import com.petproject.petserver.services.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class PetTypeController {
    private final PetTypeService petTypeService;

    @GetMapping("/pet_types")
    public ResponseEntity<List<PetType>> getAllPets() {
        return ResponseEntity.ok(petTypeService.getAllPetTypes());
    }

    @GetMapping("/pet_types/{id}")
    public ResponseEntity<PetType> getPetTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(petTypeService.getPetTypeByID(id));
    }

    @PostMapping("/pet_types")
    public ResponseEntity<PetType> createPet(PetType petType) {
        return new ResponseEntity<>(petTypeService.savePetType(petType), HttpStatus.CREATED);
    }

    @PutMapping("/pet_types/{id}")
    public ResponseEntity<PetType> changePetTypeById(PetType newPetType,
                                                     @PathVariable Long id) {
        newPetType.setId(id);
        return new ResponseEntity<>(petTypeService.savePetType(newPetType), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/pet_types/{id}")
    public ResponseEntity<String> deletePetTypeById(@PathVariable Long id) {
        petTypeService.delete(id);
        return new ResponseEntity<>("PetType doesn't exist no more", HttpStatus.ACCEPTED);
    }
}
