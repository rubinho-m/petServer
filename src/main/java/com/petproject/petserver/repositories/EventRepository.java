package com.petproject.petserver.repositories;

import com.petproject.petserver.model.Event;
import com.petproject.petserver.model.Pet;
import com.petproject.petserver.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<List<Event>> findAllByPet(Pet pet);
}
