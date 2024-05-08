package com.petproject.petserver.repositories;

import com.petproject.petserver.model.Event;
import com.petproject.petserver.model.Note;
import com.petproject.petserver.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<List<Note>> findAllByPet(Pet pet);
}
