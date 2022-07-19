package com.akata.application.mappers;

import com.akata.application.dto.ClientRequestDTO;
import com.akata.application.dto.ClientResponseDTO;
import com.akata.application.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientResponseDTO clientToClientResponseDTO(Client client);
    Client clientRequestDTOClient(ClientRequestDTO clientRequestDTO);
    Client clientResponseDTOClient(ClientResponseDTO clientResponseDTO);
}
