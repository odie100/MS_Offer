package com.akata.application.services;

import com.akata.application.dto.ContactRequestDTO;
import com.akata.application.dto.ContactResponseDTO;
import com.akata.application.entities.Contact;
import com.akata.application.mappers.ContactMapper;
import com.akata.application.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public ContactResponseDTO save(ContactRequestDTO contactRequestDTO) {
        Contact contact = this.contactMapper.contactRequestDTOContact(contactRequestDTO);
        return this.contactMapper.contactToContactResponseDTO(this.contactRepository.save(contact));
    }

    @Override
    public ContactResponseDTO getContact(Long id) {
        return this.contactMapper.contactToContactResponseDTO(this.contactRepository.findById(id).get());
    }

    @Override
    public ContactResponseDTO update(Long id, ContactRequestDTO contactRequestDTO) {
        Contact contact = this.contactMapper.contactRequestDTOContact(contactRequestDTO);
        contact.setId(id);
        return this.contactMapper.contactToContactResponseDTO(this.contactRepository.save(contact));
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.contactRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<ContactResponseDTO> getAllContact() {
        List<Contact> contacts = this.contactRepository.findAll();
        return contacts.stream().map(contact -> this.contactMapper.contactToContactResponseDTO(contact))
                .collect(Collectors.toList());
    }
}
