package com.petproject.petserver.mappers;

import com.petproject.petserver.model.Note;
import com.petproject.petserver.model.dto.NoteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteDTO toNoteDTO(Note note);
}
