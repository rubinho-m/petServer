package com.petproject.petserver.controllers;

import com.petproject.petserver.model.Note;
import com.petproject.petserver.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteByID(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getNoteByID(id));
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> createNote(Note note) {
        return new ResponseEntity<>(noteService.saveNote(note), HttpStatus.CREATED);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> changeNoteById(Note newNote,
                                                 @PathVariable Long id) {
        newNote.setId(id);
        return new ResponseEntity<>(noteService.saveNote(newNote), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/notes/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Long id) {
        noteService.delete(id);
        return new ResponseEntity<>("Note doesn't exist no more", HttpStatus.ACCEPTED);
    }
}
