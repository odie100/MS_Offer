package com.akata.application.dto;

import com.akata.application.entities.Recommendation;
import com.akata.application.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SRecommendationResponseDTO {
    Long id;
    Student student;
    Recommendation recommendation;
}
