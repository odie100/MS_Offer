package com.akata.application.dto;

import com.akata.application.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private Long id;
    private String username;
    private Location location;
    private String name;
    private String type;
    private String description;
}
