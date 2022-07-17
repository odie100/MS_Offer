package com.akata.application.mappers;

import com.akata.application.dto.OfferRequestDTO;
import com.akata.application.dto.OfferResponseDTO;
import com.akata.application.entities.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {
    OfferResponseDTO offerToOfferResponseDTO(Offer offer);
    Offer offerRequestDTOOffer (OfferRequestDTO offerRequestDTO);
}
