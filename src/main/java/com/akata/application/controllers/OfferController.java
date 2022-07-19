package com.akata.application.controllers;

import com.akata.application.dto.OfferRequestDTO;
import com.akata.application.dto.OfferResponseDTO;
import com.akata.application.entities.Offer;
import com.akata.application.mappers.CategoryMapper;
import com.akata.application.mappers.ClientMapper;
import com.akata.application.models.OfferModel;
import com.akata.application.services.CategoryService;
import com.akata.application.services.ClientService;
import com.akata.application.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping(path = "/{id}")
    public OfferResponseDTO get(@PathVariable("id") Long id){
        return this.offerService.getOffer(id);
    }

    @GetMapping(path = "/all")
    public List<OfferResponseDTO> getAll(){
        return this.offerService.getAllOffer();
    }

    @PostMapping(path = "/insert")
    public OfferResponseDTO insert(@RequestBody OfferModel offerModel){
        return this.offerService.save(offerModel);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.offerService.delete(id);
    }

    @PutMapping(path = "/update/{id}")
    public OfferResponseDTO update(@PathVariable Long id, @RequestBody OfferRequestDTO offerRequestDTO){
        return this.offerService.update(id, offerRequestDTO);
    }
}
