package com.akata.application.services;

import com.akata.application.dto.ApplyRequestDTO;
import com.akata.application.dto.ApplyResponseDTO;
import com.akata.application.models.ApplyModel;

import java.util.List;

public interface ApplyService {
    ApplyResponseDTO save(ApplyModel applyModel);

    ApplyResponseDTO getApply(Long id);

    ApplyResponseDTO update(Long id, ApplyRequestDTO applyRequestDTO);

    boolean delete(Long id);

    List<ApplyResponseDTO> getAllApplies();

}
