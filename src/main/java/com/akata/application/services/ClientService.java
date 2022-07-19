package com.akata.application.services;

import com.akata.application.dto.ClientRequestDTO;
import com.akata.application.dto.ClientResponseDTO;

import java.util.List;

public interface ClientService {
    ClientResponseDTO save(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO getClient(Long id);

    ClientResponseDTO update(Long id, ClientRequestDTO clientRequestDTO);

    boolean delete(Long id);

    List<ClientResponseDTO> getAllClients();
}