package com.akata.application.controllers;

import com.akata.application.dto.*;
import com.akata.application.mappers.ClientMapper;
import com.akata.application.mappers.LocationMapper;
import com.akata.application.mappers.StudentMapper;
import com.akata.application.models.RegistrationClientModel;
import com.akata.application.models.RegistrationStudentModel;
import com.akata.application.services.ClientService;
import com.akata.application.services.ContactService;
import com.akata.application.services.LocationService;
import com.akata.application.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/authentication")
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

        ClientResponseDTO client_saved = this.clientService.save(clientRequestDTO);
        System.out.println("Id for clientResponse: "+ client_saved.getId());
        //last Step:
        ContactRequestDTO contactRequestDTO = new ContactRequestDTO();
        contactRequestDTO.setUser(this.clientMapper.clientResponseDTOClient(client_saved));
        contactRequestDTO.setType(registrationClientModel.getContact_type());
        contactRequestDTO.setValue(registrationClientModel.getValue());
        this.contactService.save(contactRequestDTO);

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
        ContactRequestDTO contactRequestDTO = new ContactRequestDTO();
        contactRequestDTO.setType(registrationStudentModel.getContact_type());
        contactRequestDTO.setValue(registrationStudentModel.getValue());
        contactRequestDTO.setUser(this.studentMapper.studentReponseDTOStudent(student_saved));
        this.contactService.save(contactRequestDTO);

        return student_saved;
    }
}
