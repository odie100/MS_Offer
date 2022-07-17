package com.akata.application.services;

import com.akata.application.entities.StudentRecommendation;
import com.akata.application.repository.StudentRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRecommendationService {
    @Autowired
    private StudentRecommendationRepository studentRecommendationRepository;

    public StudentRecommendation insert(StudentRecommendation studentRecommendation){
        return this.studentRecommendationRepository.save(studentRecommendation);
    }

    public boolean delete(Long id){
        try {
            this.studentRecommendationRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    public StudentRecommendation update(Long id, StudentRecommendation studentRecommendation){
        studentRecommendation.setId(id);
        return this.studentRecommendationRepository.save(studentRecommendation);
    }

    public List<StudentRecommendation> getAll(){
        return this.studentRecommendationRepository.findAll();
    }

    public StudentRecommendation get(Long id){
        return this.studentRecommendationRepository.findById(id).get();
    }
}
