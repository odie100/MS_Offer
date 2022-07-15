package com.akata.application.services;

import com.akata.application.dto.OfferRequestDTO;
import com.akata.application.dto.OfferResponseDTO;

import java.util.List;

public interface OfferService {

    OfferResponseDTO save(OfferRequestDTO offerRequestDTO);

    OfferResponseDTO getOffer(Long id);

    OfferResponseDTO update(Long id, OfferRequestDTO offerRequestDTO);

    boolean delete(Long id);

    List<OfferResponseDTO> getAllOffer();
}
