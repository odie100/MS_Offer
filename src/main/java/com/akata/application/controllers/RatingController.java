package com.akata.application.controllers;

import com.akata.application.entities.Recommendation;
import com.akata.application.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping(path = "/insert")
    public Recommendation insert(@RequestBody Recommendation recommendation){
        return this.ratingService.create(recommendation);
    }

    @GetMapping(path = "/all")
    public List<Recommendation> getAll(){
        return this.ratingService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Recommendation get(@PathVariable("id") Long id){
        return this.ratingService.getRating(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.ratingService.delete(id);
    }
}
