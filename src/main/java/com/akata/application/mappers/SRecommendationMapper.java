package com.akata.application.mappers;

import com.akata.application.dto.SRecommendationRequestDTO;
import com.akata.application.dto.SRecommendationResponseDTO;
import com.akata.application.entities.StudentRecommendation;
import com.akata.application.models.RecommendationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SRecommendationMapper {
    SRecommendationResponseDTO srecommendationToSRecommendationResponseDTO(StudentRecommendation recommendation);
    StudentRecommendation recommendationRequestDTORecommendation (SRecommendationRequestDTO recommendationRequestDTO);

    //StudentRecommendation recommendationModelToStudentR(RecommendationModel recommendationModel);
}
