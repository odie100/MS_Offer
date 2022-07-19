package com.akata.application.services;

import com.akata.application.dto.RecommendationRequestDTO;
import com.akata.application.dto.RecommendationResponseDTO;

import java.util.List;

public interface RecommendationService {
    RecommendationResponseDTO save(RecommendationRequestDTO recommendationRequestDTO);
    RecommendationResponseDTO getRecommendation(Long id);
    RecommendationResponseDTO update(Long id, RecommendationRequestDTO recommendationRequestDTO);
    boolean delete(Long id);
    List<RecommendationResponseDTO> getAllRecommendation();
}
