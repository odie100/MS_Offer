package com.akata.application.controllers;

import com.akata.application.entities.StudentRating;
import com.akata.application.services.StudentRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student_rating")
public class StudentRatingController {

    @Autowired
    private StudentRatingService studentRatingService;

    @GetMapping(path = "/all")
    public List<StudentRating> getAll(){
        return this.studentRatingService.getAll();
    }

    @GetMapping(path = "/{id}")
    public StudentRating get(@PathVariable("id") Long id){
        return this.studentRatingService.get(id);
    }

    @PostMapping(path = "/insert")
    public StudentRating insert(@RequestBody StudentRating studentRating){
        return this.studentRatingService.insert(studentRating);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.studentRatingService.delete(id);
    }

    @PutMapping(path = "{id}")
    public StudentRating update(@PathVariable("id") Long id, @RequestBody StudentRating studentRating){
        return this.studentRatingService.update(id, studentRating);
    }
}
