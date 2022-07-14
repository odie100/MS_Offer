package com.akata.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private Long id;
    private String username;
    private String location;
    private String contact;
    private String type;
    private String description;
}
