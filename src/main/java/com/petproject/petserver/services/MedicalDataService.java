package com.petproject.petserver.services;

import com.petproject.petserver.exceptions.AppException;
import com.petproject.petserver.model.MedicalData;
import com.petproject.petserver.model.Pet;
import com.petproject.petserver.repositories.MedicalDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalDataService {
    private final MedicalDataRepository medicalDataRepository;

    public List<MedicalData> getAllMedicalData() {
        return medicalDataRepository.findAll();
    }

    public List<MedicalData> getAllMedicalDataByPet(Pet pet) {
        return medicalDataRepository.findAllByPet(pet)
                .orElseThrow(() -> new AppException("The pet with this id doesn't exist", HttpStatus.NOT_FOUND));
    }

    public MedicalData getMedicalDataByID(Long id) {
        return medicalDataRepository.findById(id)
                .orElseThrow(() -> new AppException("The medical data with this id doesn't exist", HttpStatus.NOT_FOUND));

    }

    public MedicalData saveMedicalData(MedicalData medicalData) {
        return medicalDataRepository.save(medicalData);
    }

    public void delete(Long id) {
        medicalDataRepository.deleteById(id);
    }
}
