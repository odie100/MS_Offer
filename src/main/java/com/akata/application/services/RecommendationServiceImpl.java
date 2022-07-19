package com.akata.application.services;

import com.akata.application.dto.RecommendationRequestDTO;
import com.akata.application.dto.RecommendationResponseDTO;
import com.akata.application.entities.Recommendation;
import com.akata.application.mappers.RecommendationMapper;
import com.akata.application.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationMapper recommendationMapper;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public RecommendationResponseDTO save(RecommendationRequestDTO recommendationRequestDTO) {
        Recommendation recommendation = this.recommendationMapper
                .recommendationRequestDTORecommendation(recommendationRequestDTO);
        return this.recommendationMapper.recommendationToRecommendationResponseDTO(this.recommendationRepository
                .save(recommendation));
    }

    @Override
    public RecommendationResponseDTO getRecommendation(Long id) {
        return this.recommendationMapper.recommendationToRecommendationResponseDTO(
                this.recommendationRepository.findById(id).get()
        );
    }

    @Override
    public RecommendationResponseDTO update(Long id, RecommendationRequestDTO recommendationRequestDTO) {
        Recommendation recommendation = this.recommendationMapper
                .recommendationRequestDTORecommendation(recommendationRequestDTO);
        recommendation.setId(id);
        return this.recommendationMapper.recommendationToRecommendationResponseDTO(
                this.recommendationRepository.save(recommendation)
        );
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.recommendationRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<RecommendationResponseDTO> getAllRecommendation() {
        List<Recommendation> recommendations = this.recommendationRepository.findAll();
        return recommendations.stream().map(recommendation -> this.recommendationMapper
                .recommendationToRecommendationResponseDTO(recommendation)).collect(Collectors.toList());
    }
}
