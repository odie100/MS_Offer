package com.akata.application.services;

import com.akata.application.dto.OfferRequestDTO;
import com.akata.application.dto.OfferResponseDTO;
import com.akata.application.entities.Offer;
import com.akata.application.mappers.OfferMapper;
import com.akata.application.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private OfferMapper offerMapper;

    @Override
    public OfferResponseDTO save(OfferRequestDTO offerRequestDTO) {
        Offer offer = this.offerMapper.offerRequestDTOOffer(offerRequestDTO);
        return this.offerMapper.offerToOfferResponseDTO(this.offerRepository.save(offer));
    }

    @Override
    public OfferResponseDTO getOffer(Long id) {
        return this.offerMapper.offerToOfferResponseDTO(this.offerRepository.findById(id).get());
    }

    @Override
    public OfferResponseDTO update(Long id, OfferRequestDTO offerRequestDTO) {
        Offer offer = this.offerMapper.offerRequestDTOOffer(offerRequestDTO);
        offer.setOffer_id(id);
        return this.offerMapper.offerToOfferResponseDTO(this.offerRepository.save(offer));
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.offerRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<OfferResponseDTO> getAllOffer() {
        List<Offer> offers = this.offerRepository.findAll();
        return offers.stream().map(offer -> this.offerMapper.offerToOfferResponseDTO(offer)).collect(Collectors.toList());
    }
}
