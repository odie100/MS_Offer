package com.akata.application.mappers;

import com.akata.application.dto.CategoryRequestDTO;
import com.akata.application.dto.CategoryResponseDTO;
import com.akata.application.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponseDTO categoryToCategoryResponseDTO(Category category);
    Category categoryRequestDTOCategory (CategoryRequestDTO categoryRequestDTO);

    Category categoryResponseDTOCategory(CategoryResponseDTO categoryResponseDTO);
}
