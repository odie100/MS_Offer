package com.akata.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RegistrationStudentModel {
    String country;
    String address;
    String town;
    String username;
    String password;
    String firstname;
    String school;
    String level;
    String school_career;
    String bio;
    String contact_type;
    String value;
    Long id_location;
}
