package com.petproject.petserver.services;

import com.petproject.petserver.exceptions.AppException;
import com.petproject.petserver.mappers.EventMapper;
import com.petproject.petserver.mappers.MedicalDataMapper;
import com.petproject.petserver.mappers.NoteMapper;
import com.petproject.petserver.mappers.PetMapper;

import com.petproject.petserver.model.Pet;
import com.petproject.petserver.model.dto.EventDTO;
import com.petproject.petserver.model.dto.MedicalDataDTO;
import com.petproject.petserver.model.dto.NoteDTO;
import com.petproject.petserver.model.dto.PetDTO;
import com.petproject.petserver.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final NoteService noteService;
    private final EventService eventService;
    private final MedicalDataService medicalDataService;
    private final PetRepository petRepository;
    private final PetMapperService petMapperService;
    private final PetMapper petMapper;
    private final EventMapper eventMapper;
    private final NoteMapper noteMapper;
    private final MedicalDataMapper medicalDataMapper;

    public List<PetDTO> getAllPets() {
        return petRepository.findAll()
                .stream()
                .map(petMapper::toPetDTO)
                .map(this::fillLists)
                .toList();
    }

    public PetDTO getPetById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new AppException("The event with this id doesn't exist", HttpStatus.NOT_FOUND));
        return fillLists(petMapper.toPetDTO(pet));
    }

    private PetDTO fillLists(PetDTO petDTO) {
        Pet pet = petMapperService.dtoToPet(petDTO);

        List<EventDTO> eventList = eventService.getAllEventsByPet(pet).stream().map(eventMapper::toEventDTO).toList();
        List<NoteDTO> noteList = noteService.getAllNotesByPet(pet).stream().map(noteMapper::toNoteDTO).toList();
        List<MedicalDataDTO> medicalDataList = medicalDataService.getAllMedicalDataByPet(pet)
                .stream()
                .map(medicalDataMapper::toMedicalDataDTO)
                .toList();

        petDTO.setEventList(eventList);
        petDTO.setNoteList(noteList);
        petDTO.setMedicalDataList(medicalDataList);

        return petDTO;
    }


    public Pet savePet(PetDTO petDTO) {
        return petRepository.save(petMapperService.dtoToPet(petDTO));
    }

    public void delete(Long id) {
        deleteAllLists(id);
        petRepository.deleteById(id);
    }

    private void deleteAllLists(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new AppException("The event with this id doesn't exist", HttpStatus.NOT_FOUND));

        eventService.getAllEventsByPet(pet).forEach(event -> eventService.delete(event.getId()));
        noteService.getAllNotesByPet(pet).forEach(note -> noteService.delete(note.getId()));
        medicalDataService.getAllMedicalDataByPet(pet).forEach(medicalData -> medicalDataService.delete(medicalData.getId()));

    }
}
