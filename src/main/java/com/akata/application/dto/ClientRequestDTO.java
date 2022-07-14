package com.akata.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {
    private String username;
    private String password;
    private String location;
    private String contact;
    private String type;
    private String description;
}
