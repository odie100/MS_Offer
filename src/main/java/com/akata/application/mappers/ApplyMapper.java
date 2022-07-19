package com.akata.application.mappers;

import com.akata.application.dto.ApplyRequestDTO;
import com.akata.application.dto.ApplyResponseDTO;
import com.akata.application.entities.Apply;
import com.akata.application.models.ApplyModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplyMapper {
    ApplyResponseDTO applyToApplyResponseDTO(Apply apply);
    Apply applyRequestDTOApply (ApplyRequestDTO applyRequestDTO);
    Apply applyResponseDTOApply(ApplyResponseDTO applyResponseDTO);
    Apply applyModelTOApply(ApplyModel applyModel);
}
