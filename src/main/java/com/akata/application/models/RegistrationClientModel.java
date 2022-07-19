package com.akata.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RegistrationClientModel {
    String country;
    String address;
    String town;
    String username;
    String password;
    String type;
    String description;
    String contact_type;
    String value;
    Long id_location;
}
