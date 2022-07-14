package com.akata.application.controllers;

import com.akata.application.dto.ClientRequestDTO;
import com.akata.application.dto.ClientResponseDTO;
import com.akata.application.services.ClientService;
import com.akata.application.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientServiceImpl clientServiceImplementation;

    @PostMapping(path = "/insert")
    public ClientResponseDTO insert(@RequestBody ClientRequestDTO clientRequestDTO){
        return clientService.save(clientRequestDTO);
    }

    @GetMapping(path = "/clients")
    public List<ClientResponseDTO> clients(){
        return clientServiceImplementation.getAllClients();
    }
}
