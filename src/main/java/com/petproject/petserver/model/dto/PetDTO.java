package com.petproject.petserver.model.dto;

import com.petproject.petserver.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PetDTO {
    private Long id;
    private User user;
    private String name;
    private String type;
    private String imageURI;
    private Long dateOfBirth;
    private Float weight;
    private List<EventDTO> eventList;
    private List<NoteDTO> noteList;
    private List<MedicalDataDTO> medicalDataList;

}
