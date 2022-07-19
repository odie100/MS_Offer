package com.akata.application.services;

import com.akata.application.dto.StudentRequestDTO;
import com.akata.application.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO save(StudentRequestDTO studentRequestDTO);
    StudentResponseDTO getStudent(Long id);

    StudentResponseDTO update(Long id, StudentRequestDTO studentRequestDTO);

    boolean delete(Long id);
    List<StudentResponseDTO> getAllStudents();
}
