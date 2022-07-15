package com.akata.application.services;

import com.akata.application.entities.Rating;
import com.akata.application.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating create(Rating rating){
        return this.ratingRepository.save(rating);
    }

    public Rating getRating(Long id){
        return this.ratingRepository.findById(id).get();
    }

    public List<Rating> getAll(){
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

    public Rating update(Long id, Rating rating){
        rating.setId(id);
        return this.ratingRepository.save(rating);
    }
}
