package com.akata.application.services;

import com.akata.application.dto.CategoryRequestDTO;
import com.akata.application.dto.CategoryResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    CategoryResponseDTO save(CategoryRequestDTO categoryRequestDTO);

    CategoryResponseDTO getCategory(Long id);

    CategoryResponseDTO update(Long id, CategoryRequestDTO categoryRequestDTO);

    boolean delete(Long id);

    List<CategoryResponseDTO> getAllCategories();
}
