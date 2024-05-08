package com.petproject.petserver.repositories;

import com.petproject.petserver.model.MedicalData;
import com.petproject.petserver.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalDataRepository extends JpaRepository<MedicalData, Long> {
    Optional<List<MedicalData>> findAllByPet(Pet pet);
}
