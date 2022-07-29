package com.akata.application.controllers;

import com.akata.application.dto.*;
import com.akata.application.mappers.ClientMapper;
import com.akata.application.mappers.LocationMapper;
import com.akata.application.mappers.StudentMapper;
import com.akata.application.models.RegistrationClientModel;
import com.akata.application.models.RegistrationStudentModel;
import com.akata.application.models.SignInModel;
import com.akata.application.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/register/client")
    public ClientResponseDTO register(@RequestBody RegistrationClientModel registrationClientModel){
        //Step 1:
        LocationRequestDTO locationRequestDTO = new LocationRequestDTO();
        locationRequestDTO.setCountry(registrationClientModel.getCountry());
        locationRequestDTO.setTown(registrationClientModel.getTown());
        locationRequestDTO.setAddress(registrationClientModel.getAddress());
        LocationResponseDTO location_saved = this.locationService.save(locationRequestDTO);
        //Step 2:
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setDescription(registrationClientModel.getDescription());
        clientRequestDTO.setLocation(this.locationMapper.locationResponseToLocation(location_saved));
        clientRequestDTO.setPassword(registrationClientModel.getPassword());
        clientRequestDTO.setUsername(registrationClientModel.getUsername());
        clientRequestDTO.setType(registrationClientModel.getType());
        clientRequestDTO.setName(registrationClientModel.getName());

        ClientResponseDTO client_saved = this.clientService.save(clientRequestDTO);
        System.out.println("name: "+clientRequestDTO.getName());
        //last Step:
        if(!registrationClientModel.getEmail().isEmpty()){
            ContactRequestDTO email_contact = new ContactRequestDTO();
            email_contact.setUser(this.clientMapper.clientResponseDTOClient(client_saved));
            email_contact.setType("email");
            email_contact.setValue(registrationClientModel.getEmail());
            this.contactService.save(email_contact);
        }

        if(!registrationClientModel.getTel().isEmpty()){
            ContactRequestDTO tel_contact = new ContactRequestDTO();
            tel_contact.setUser(this.clientMapper.clientResponseDTOClient(client_saved));
            tel_contact.setType("tel");
            tel_contact.setValue(registrationClientModel.getTel());
            this.contactService.save(tel_contact);
        }

        return client_saved;
    }

    @PostMapping(path = "/register/student")
    public StudentResponseDTO register(@RequestBody RegistrationStudentModel registrationStudentModel){
        //Step 1:
        LocationRequestDTO locationRequestDTO = new LocationRequestDTO();
        locationRequestDTO.setAddress(registrationStudentModel.getAddress());
        locationRequestDTO.setCountry(registrationStudentModel.getCountry());
        locationRequestDTO.setTown(registrationStudentModel.getTown());
        LocationResponseDTO locationResponseDTO = this.locationService.save(locationRequestDTO);
        //Step 2:
        StudentRequestDTO studentRequestDTO = new StudentRequestDTO();
        studentRequestDTO.setLocation(this.locationMapper.locationResponseToLocation(locationResponseDTO));
        studentRequestDTO.setPassword(registrationStudentModel.getPassword());
        studentRequestDTO.setUsername(registrationStudentModel.getUsername());
        studentRequestDTO.setFirstname(registrationStudentModel.getFirstname());
        studentRequestDTO.setLevel(registrationStudentModel.getLevel());
        studentRequestDTO.setSchool(registrationStudentModel.getSchool());
        studentRequestDTO.setSchool_career(registrationStudentModel.getSchool_career());
        studentRequestDTO.setBio(registrationStudentModel.getBio());
        StudentResponseDTO student_saved = this.studentService.save(studentRequestDTO);
        //last Step:
        if(!registrationStudentModel.getEmail().isEmpty()){
            ContactRequestDTO email_contact = new ContactRequestDTO();
            email_contact.setType("email");
            email_contact.setValue(registrationStudentModel.getEmail());
            email_contact.setUser(this.studentMapper.studentReponseDTOStudent(student_saved));
            this.contactService.save(email_contact);
        }

        if(!registrationStudentModel.getTel().isEmpty()){
            ContactRequestDTO tel_contact = new ContactRequestDTO();
            tel_contact.setType("tel");
            tel_contact.setValue(registrationStudentModel.getTel());
            tel_contact.setUser(this.studentMapper.studentReponseDTOStudent(student_saved));
            this.contactService.save(tel_contact);
        }

        return student_saved;
    }

    @PostMapping(path = "/signin")
    public Object signIn(@RequestBody SignInModel signInModel){
        if(signInModel.getType().equals("client")){
            return this.clientService.signIn(signInModel.getPassword(), signInModel.getEmail());
        }else {
            return this.studentService.signIn(signInModel.getEmail(), signInModel.getPassword());
        }
    }
}
