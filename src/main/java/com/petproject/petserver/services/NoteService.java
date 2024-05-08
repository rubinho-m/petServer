package com.petproject.petserver.services;

import com.petproject.petserver.exceptions.AppException;
import com.petproject.petserver.model.Note;
import com.petproject.petserver.model.Pet;
import com.petproject.petserver.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<Note> getAllNotesByPet(Pet pet) {
        return noteRepository.findAllByPet(pet)
                .orElseThrow(() -> new AppException("The pet with this id doesn't exist", HttpStatus.NOT_FOUND));
    }

    public Note getNoteByID(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new AppException("The note with this id doesn't exist", HttpStatus.NOT_FOUND));

    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }


    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
