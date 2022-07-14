package com.akata.application.services;

import com.akata.application.dto.ClientRequestDTO;
import com.akata.application.dto.ClientResponseDTO;
import com.akata.application.entities.Client;
import com.akata.application.mappers.ClientMapper;
import com.akata.application.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

/*    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper mapper){
        this.clientRepository = clientRepository;
        this.clientMapper = mapper;
    }*/

    @Override
    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        Client client = clientMapper.clientRequestDTOClient(clientRequestDTO);
        Client saved_client = clientRepository.save(client);
        return clientMapper.clientToClientResponseDTO(saved_client);
    }

    @Override
    public ClientResponseDTO getClient(Long id) {
        return null;
    }

    @Override
    public ClientResponseDTO update(ClientRequestDTO clientRequestDTO) {
        return null;
    }

    @Override
    public List<ClientResponseDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponseDTO> clientsResponseDTO = clients.stream()
                .map(client -> clientMapper.clientToClientResponseDTO(client)).collect(Collectors.toList());
        System.out.println("here is the result : "+ clientsResponseDTO);
        return clientsResponseDTO;
    }
}
