package com.petproject.petserver.repositories;

import com.petproject.petserver.model.Pet;
import com.petproject.petserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<List<Pet>> findAllByUser(User user);
}
