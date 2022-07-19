package com.akata.application.dto;

import com.akata.application.entities.Offer;
import com.akata.application.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ApplyRequestDTO {
    Student student;
    Offer offer;
}
