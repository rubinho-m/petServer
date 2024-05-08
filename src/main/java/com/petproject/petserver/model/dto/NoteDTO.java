package com.petproject.petserver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoteDTO {
    private Long id;
    private String text;
    private Integer iconResId;
}
