package com.petproject.petserver.services;

import com.petproject.petserver.exceptions.AppException;
import com.petproject.petserver.model.Event;
import com.petproject.petserver.model.Pet;
import com.petproject.petserver.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getAllEventsByPet(Pet pet) {
        return eventRepository.findAllByPet(pet)
                .orElseThrow(() -> new AppException("The pet with this id doesn't exist", HttpStatus.NOT_FOUND));
    }

    public Event getEventByID(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new AppException("The event with this id doesn't exist", HttpStatus.NOT_FOUND));

    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
