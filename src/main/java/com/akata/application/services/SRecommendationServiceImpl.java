package com.akata.application.services;

import com.akata.application.dto.RecommendationRequestDTO;
import com.akata.application.dto.RecommendationResponseDTO;
import com.akata.application.dto.SRecommendationRequestDTO;
import com.akata.application.dto.SRecommendationResponseDTO;
import com.akata.application.entities.Recommendation;
import com.akata.application.entities.Student;
import com.akata.application.entities.StudentRecommendation;
import com.akata.application.mappers.RecommendationMapper;
import com.akata.application.mappers.SRecommendationMapper;
import com.akata.application.mappers.StudentMapper;
import com.akata.application.models.RecommendationModel;
import com.akata.application.repository.StudentRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SRecommendationServiceImpl implements SRecommendationService {

    @Autowired
    private StudentRecommendationRepository studentRecommendationRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private RecommendationMapper recommendationMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SRecommendationMapper sRecommendationMapper;

    @Override
    public SRecommendationResponseDTO save(RecommendationModel recommendationModel) {

        RecommendationRequestDTO recommendation = new RecommendationRequestDTO();
        recommendation.setRecommendation(recommendationModel.getRecommendation());

        RecommendationResponseDTO saved_recommendation = this.recommendationService.save(recommendation);

        StudentRecommendation studentRecommendation = new StudentRecommendation();

        Student student = this.studentMapper.studentReponseDTOStudent(
                this.studentService.getStudent(recommendationModel.getId_student())
        );

     /*   Recommendation recom = this.recommendationMapper.recomResponseToRecom(
                this.recommendationService.getRecommendation(saved_recommendation.getId())
        );*/

        studentRecommendation.setStudent(student);
        studentRecommendation.setRecommendation(this.recommendationMapper.recomResponseToRecom(saved_recommendation));

        return this.sRecommendationMapper.srecommendationToSRecommendationResponseDTO(
                this.studentRecommendationRepository.save(studentRecommendation)
        );
    }

    @Override
    public SRecommendationResponseDTO getSRecommendation(Long id) {
        return this.sRecommendationMapper.srecommendationToSRecommendationResponseDTO(
                this.studentRecommendationRepository.findById(id).get()
        );
    }

    @Override
    public SRecommendationResponseDTO update(Long id, SRecommendationRequestDTO sRecommendationRequestDTO) {
        StudentRecommendation studentRecommendation = this.sRecommendationMapper
                .recommendationRequestDTORecommendation(sRecommendationRequestDTO);
        studentRecommendation.setId(id);
        return this.sRecommendationMapper.srecommendationToSRecommendationResponseDTO(
                this.studentRecommendationRepository.save(studentRecommendation)
        );
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.studentRecommendationRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<SRecommendationResponseDTO> getAllSRecommendation() {
        List<StudentRecommendation> studentRecommendations  = this.studentRecommendationRepository.findAll();
        return studentRecommendations.stream().map(studentRecommendation -> this.sRecommendationMapper
                .srecommendationToSRecommendationResponseDTO(studentRecommendation)).collect(Collectors.toList());
    }
}
