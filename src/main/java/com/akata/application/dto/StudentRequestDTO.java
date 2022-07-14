package com.akata.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StudentRequestDTO {
    private String username;
    private String password;
    private String location;
    private String contact;
    private String experiences;
    private String firstname;
    private String level;
    private String school;
    private String school_career;
}
