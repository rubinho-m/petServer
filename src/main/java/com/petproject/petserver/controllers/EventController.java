package com.petproject.petserver.controllers;

import com.petproject.petserver.model.Event;
import com.petproject.petserver.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class EventController {
    private final EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventByID(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventByID(id));
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(Event event) {
        return new ResponseEntity<>(eventService.saveEvent(event), HttpStatus.CREATED);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> changeEventById(Event newEvent,
                                                 @PathVariable Long id) {
        newEvent.setId(id);
        return new ResponseEntity<>(eventService.saveEvent(newEvent), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/events/{id}")
    public ResponseEntity<String> deleteEventById(@PathVariable Long id) {
        eventService.delete(id);
        return new ResponseEntity<>("Event doesn't exist no more", HttpStatus.ACCEPTED);
    }
}
