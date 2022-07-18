package com.akata.application.dto;

import com.akata.application.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class StudentResponseDTO {
    private Long id;
    private String username;
    private Location location;
    private String firstname;
    private String level;
    private String school;
    private String school_career;
}
