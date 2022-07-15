package com.akata.application.controllers;

import com.akata.application.entities.Rating;
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
    public Rating insert(@RequestBody Rating rating){
        return this.ratingService.create(rating);
    }

    @GetMapping(path = "/all")
    public List<Rating> getAll(){
        return this.ratingService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Rating get(@PathVariable("id") Long id){
        return this.ratingService.getRating(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.ratingService.delete(id);
    }
}
