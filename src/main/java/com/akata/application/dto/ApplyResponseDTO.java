package com.akata.application.dto;

import com.akata.application.entities.Offer;
import com.akata.application.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class ApplyResponseDTO {
    Long id;
    Student student;
    Offer offer;
    LocalDate apply_date;
    String status;
}