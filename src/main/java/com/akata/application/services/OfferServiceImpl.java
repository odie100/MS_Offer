package com.akata.application.services;

import com.akata.application.dto.OfferRequestDTO;
import com.akata.application.dto.OfferResponseDTO;
import com.akata.application.entities.Category;
import com.akata.application.entities.Client;
import com.akata.application.entities.Offer;
import com.akata.application.mappers.CategoryMapper;
import com.akata.application.mappers.ClientMapper;
import com.akata.application.mappers.OfferMapper;
import com.akata.application.models.OfferModel;
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
    private ClientMapper clientMapper;

    @Autowired
    private OfferMapper offerMapper;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryService categoryService;

    @Override
    public OfferResponseDTO save(OfferModel offerModel) {
        /*Offer offer = this.offerMapper.offerRequestDTOOffer(offerRequestDTO);
        Client client = this.clientMapper.clientResponseDTOClient(this.clientService.getClient(offer.getClient().getId()));
        Category category = this.categoryMapper.categoryResponseDTOCategory(this.categoryService.getCategory(offer.getCategories().getId()));
        offer.setClient(client);
        offer.setCategories(category);*/
        OfferRequestDTO offerRequestDTO = new OfferRequestDTO();
        offerRequestDTO.setClient(this.clientMapper.clientResponseDTOClient(this.clientService
                .getClient(offerModel.getClient())));
        offerRequestDTO.setApplicant_number(offerModel.getApplicant_number());
        offerRequestDTO.setDeadline(offerModel.getDeadline());
        offerRequestDTO.setDetails(offerModel.getDetails());
        offerRequestDTO.setTechnology(offerModel.getTechnology());
        offerRequestDTO.setPost_date(offerModel.getPost_date());
        offerRequestDTO.setTheme(offerModel.getTheme());
        offerRequestDTO.setType(offerModel.getType());
        offerRequestDTO.setCategory(this.categoryMapper.categoryResponseDTOCategory(this.categoryService
                .getCategory(offerModel.getCategory())));

        System.out.println("category: "+ offerRequestDTO.getCategory().getName()+" Id: "+offerRequestDTO.getCategory().getId());

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
