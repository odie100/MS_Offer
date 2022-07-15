package com.akata.application.mappers;

import com.akata.application.dto.ContactRequestDTO;
import com.akata.application.dto.ContactResponseDTO;
import com.akata.application.entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactResponseDTO contactToContactResponseDTO(Contact contact);
    Contact contactRequestDTOContact (ContactRequestDTO contactRequestDTO);
}
