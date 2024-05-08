package com.petproject.petserver.repositories;

import com.petproject.petserver.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
    Optional<PetType> findPetTypeByType(String type);
}
