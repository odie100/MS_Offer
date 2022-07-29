package com.akata.application.dto;

import com.akata.application.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {
    private String username;
    private String password;
    private Location location;
    private String type;
    private String description;
    private String name;
}
