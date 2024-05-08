package com.petproject.petserver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MedicalDataDTO {
    private Long id;
    private String name;
    private Long date;
    private Long time;
    private String imageURI;
    private String note;
}
