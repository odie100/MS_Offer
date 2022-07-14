package com.akata.application.mappers;

import com.akata.application.dto.StudentRequestDTO;
import com.akata.application.dto.StudentResponseDTO;
import com.akata.application.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentResponseDTO studentToStudentResponseDTO(Student student);
    Student studentRequestDTOStudent(StudentRequestDTO studentRequestDTO);
}
