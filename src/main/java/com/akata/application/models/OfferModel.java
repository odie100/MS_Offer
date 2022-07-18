package com.akata.application.models;

import com.akata.application.entities.Category;
import com.akata.application.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class OfferModel {
    private String theme;
    private String details;
    private LocalDate deadline;
    private String type;
    private String technology;
    private LocalDate post_date;
    private int applicant_number;
    private Long client;
    private Long category;
}
