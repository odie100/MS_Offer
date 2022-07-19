package com.akata.application.services;

import com.akata.application.dto.SRecommendationRequestDTO;
import com.akata.application.dto.SRecommendationResponseDTO;
import com.akata.application.models.RecommendationModel;

import java.util.List;

public interface SRecommendationService {
    SRecommendationResponseDTO save(RecommendationModel recommendationModel);

    SRecommendationResponseDTO getSRecommendation(Long id);

    SRecommendationResponseDTO update(Long id, SRecommendationRequestDTO sRecommendationRequestDTO);

    boolean delete(Long id);

    List<SRecommendationResponseDTO> getAllSRecommendation();
}
