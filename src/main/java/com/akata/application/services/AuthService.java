package com.akata.application.services;

import com.akata.application.dto.ClientResponseDTO;
import com.akata.application.dto.StudentResponseDTO;
import com.akata.application.models.SignInModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private StudentService studentService;

 /*   public ClientResponseDTO signInClient(SignInModel signInModel){
        this.c
    }

    public StudentResponseDTO signInStudent(SignInModel signInModel){

    }*/
}
