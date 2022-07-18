package com.akata.application.services;

import com.akata.application.entities.Recommendation;
import com.akata.application.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Recommendation create(Recommendation recommendation){
        return this.ratingRepository.save(recommendation);
    }

    public Recommendation getRating(Long id){
        return this.ratingRepository.findById(id).get();
    }

    public List<Recommendation> getAll(){
        return this.ratingRepository.findAll();
    }

    public boolean delete(Long id){
        try {
            this.ratingRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    public Recommendation update(Long id, Recommendation recommendation){
        recommendation.setId(id);
        return this.ratingRepository.save(recommendation);
    }
}
