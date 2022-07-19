package com.akata.application.services;

import com.akata.application.dto.ClientRequestDTO;
import com.akata.application.dto.ClientResponseDTO;
import com.akata.application.entities.Client;
import com.akata.application.mappers.ClientMapper;
import com.akata.application.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

    @Override
    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        Client saved_client = clientRepository.save(clientMapper.clientRequestDTOClient(clientRequestDTO));
        return clientMapper.clientToClientResponseDTO(saved_client);
    }

    @Override
    public ClientResponseDTO getClient(Long id) {
        Client client = clientRepository.findById(id).get();
        return clientMapper.clientToClientResponseDTO(client);
    }


    @Override
    public ClientResponseDTO update(Long id, ClientRequestDTO clientRequestDTO) {
        Client client = clientMapper.clientRequestDTOClient(clientRequestDTO);
        client.setId(id);
        return clientMapper.clientToClientResponseDTO(clientRepository.save(client));
    }

    @Override
    public boolean delete(Long id) {
        try {
            clientRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<ClientResponseDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(client -> clientMapper.clientToClientResponseDTO(client)).collect(Collectors.toList());
    }
}
