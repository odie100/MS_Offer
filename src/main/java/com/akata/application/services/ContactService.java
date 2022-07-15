package com.akata.application.services;


import com.akata.application.dto.ContactRequestDTO;
import com.akata.application.dto.ContactResponseDTO;

import java.util.List;

public interface ContactService {
    ContactResponseDTO save(ContactRequestDTO contactRequestDTO);

    ContactResponseDTO getContact(Long id);

    ContactResponseDTO update(Long id, ContactRequestDTO contactRequestDTO);

    boolean delete(Long id);

    List<ContactResponseDTO> getAllContact();
}
