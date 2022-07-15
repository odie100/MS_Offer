package com.akata.application.services;

import com.akata.application.entities.StudentRating;
import com.akata.application.repository.StudentRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRatingService {
    @Autowired
    private StudentRatingRepository studentRatingRepository;

    public StudentRating insert(StudentRating studentRating){
        return this.studentRatingRepository.save(studentRating);
    }

    public boolean delete(Long id){
        try {
            this.studentRatingRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    public StudentRating update(Long id, StudentRating studentRating){
        studentRating.setId(id);
        return this.studentRatingRepository.save(studentRating);
    }

    public List<StudentRating> getAll(){
        return this.studentRatingRepository.findAll();
    }

    public StudentRating get(Long id){
        return this.studentRatingRepository.findById(id).get();
    }
}
