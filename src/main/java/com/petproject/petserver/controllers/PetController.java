package com.petproject.petserver.controllers;

import com.petproject.petserver.model.Pet;
import com.petproject.petserver.model.dto.PetDTO;
import com.petproject.petserver.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class PetController {
    private final PetService petService;

    @GetMapping("/pets")
    public ResponseEntity<List<PetDTO>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PostMapping("/pets")
    public ResponseEntity<Pet> createPet(PetDTO petDTO) {
        return new ResponseEntity<>(petService.savePet(petDTO), HttpStatus.CREATED);
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, PetDTO newPetDTO) {
        newPetDTO.setId(id);
        return new ResponseEntity<>(petService.savePet(newPetDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<String> deletePet(@PathVariable Long id) {
        petService.delete(id);
        return new ResponseEntity<>("Pet doesn't exist no more", HttpStatus.ACCEPTED);
    }
}
