package com.akata.application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student extends User{
    private String firstname;
    private String school;
    private String level;
    private String school_career;
    private String bio;

    @OneToMany(mappedBy = "student")
    Set<Apply> apply;

    @OneToMany(mappedBy = "student")
    Set<StudentRecommendation> ratings;
}
