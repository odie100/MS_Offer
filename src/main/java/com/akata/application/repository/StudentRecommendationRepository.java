package com.akata.application.repository;

import com.akata.application.entities.StudentRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRecommendationRepository extends JpaRepository<StudentRecommendation,Long> {
}
