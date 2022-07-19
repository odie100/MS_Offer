package com.akata.application.dto;

import com.akata.application.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ContactRequestDTO {
    String type;
    String value;
    User user;
}
