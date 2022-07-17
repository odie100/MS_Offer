package com.akata.application.controllers;

import com.akata.application.dto.ApplyRequestDTO;
import com.akata.application.dto.ApplyResponseDTO;
import com.akata.application.models.ApplyModel;
import com.akata.application.services.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/apply")
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @GetMapping(path = "/{id}")
    public ApplyResponseDTO get(@PathVariable("id") Long id){
        return this.applyService.getApply(id);
    }

    @GetMapping(path = "/all")
    public List<ApplyResponseDTO> getAll(){
        return this.applyService.getAllApplies();
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.applyService.delete(id);
    }

    @PutMapping(path = "/update/{id}")
    public ApplyResponseDTO update(@PathVariable("id") Long id, @RequestBody ApplyRequestDTO applyRequestDTO){
        return this.applyService.update(id, applyRequestDTO);
    }

    @PostMapping(path = "/insert")
    public ApplyResponseDTO insert(@RequestBody ApplyModel applyModel){
        return this.applyService.save(applyModel);
    }
}
