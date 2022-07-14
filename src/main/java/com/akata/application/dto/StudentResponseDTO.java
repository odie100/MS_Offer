package com.akata.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class StudentResponseDTO {
    private Long id;
    private String username;
    private String location;
    private String contact;
    private String experiences;
    private String firstname;
    private String level;
    private String school;
    private String school_career;
}
