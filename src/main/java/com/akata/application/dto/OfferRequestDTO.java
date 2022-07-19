package com.akata.application.dto;

import com.akata.application.entities.Category;
import com.akata.application.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class OfferRequestDTO {
    private String theme;
    private String details;
    private LocalDate deadline;
    private String type;
    private String technology;
    private LocalDate post_date;
    private int applicant_number;

    Client client;
    Category category;
}
