package com.akata.application.controllers;

import com.akata.application.entities.StudentRecommendation;
import com.akata.application.services.StudentRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student_rating")
public class StudentRatingController {

    @Autowired
    private StudentRecommendationService studentRecommendationService;

    @GetMapping(path = "/all")
    public List<StudentRecommendation> getAll(){
        return this.studentRecommendationService.getAll();
    }

    @GetMapping(path = "/{id}")
    public StudentRecommendation get(@PathVariable("id") Long id){
        return this.studentRecommendationService.get(id);
    }

    @PostMapping(path = "/insert")
    public StudentRecommendation insert(@RequestBody StudentRecommendation studentRecommendation){
        return this.studentRecommendationService.insert(studentRecommendation);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.studentRecommendationService.delete(id);
    }

    @PutMapping(path = "{id}")
    public StudentRecommendation update(@PathVariable("id") Long id, @RequestBody StudentRecommendation studentRecommendation){
        return this.studentRecommendationService.update(id, studentRecommendation);
    }
}
