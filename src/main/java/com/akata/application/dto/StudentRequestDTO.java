package com.akata.application.dto;

import com.akata.application.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StudentRequestDTO {
    private String username;
    private String password;
    private Location location;
    private String firstname;
    private String level;
    private String school;
    private String school_career;
    private String bio;
}
