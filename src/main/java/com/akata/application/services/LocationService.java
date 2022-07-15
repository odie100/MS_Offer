package com.akata.application.services;

import com.akata.application.dto.LocationRequestDTO;
import com.akata.application.dto.LocationResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    LocationResponseDTO save(LocationRequestDTO locationRequestDTO);

    LocationResponseDTO getLocation(Long id);

    LocationResponseDTO update(Long id, LocationRequestDTO locationRequestDTO);

    boolean delete(Long id);

    List<LocationResponseDTO> getAllLocation();
}
