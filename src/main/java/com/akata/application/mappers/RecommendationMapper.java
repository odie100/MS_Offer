package com.akata.application.mappers;

import com.akata.application.dto.RecommendationRequestDTO;
import com.akata.application.dto.RecommendationResponseDTO;
import com.akata.application.entities.Recommendation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    RecommendationResponseDTO recommendationToRecommendationResponseDTO(Recommendation recommendation);
    Recommendation recommendationRequestDTORecommendation (RecommendationRequestDTO recommendationRequestDTO);
    Recommendation recomResponseToRecom(RecommendationResponseDTO recommendationResponseDTO);
}
