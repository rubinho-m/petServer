package com.petproject.petserver.services;

import com.petproject.petserver.exceptions.AppException;
import com.petproject.petserver.model.Pet;
import com.petproject.petserver.model.User;
import com.petproject.petserver.repositories.PetRepository;
import com.petproject.petserver.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PetRepository petRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new AppException("The user with this id doesn't exist", HttpStatus.NOT_FOUND));

    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        System.out.println(id);
        List<Pet> userPets = petRepository.findAllByUser(getUserById(id))
                .orElseThrow(() -> new AppException("The user pets with this id doesn't exist", HttpStatus.NOT_FOUND));
        userPets.forEach(pet -> petRepository.deleteById(pet.getId()));
        System.out.println(userPets.size());
        userRepository.deleteById(id);
    }
}
