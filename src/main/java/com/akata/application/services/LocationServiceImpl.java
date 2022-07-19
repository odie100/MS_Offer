package com.akata.application.services;

import com.akata.application.dto.LocationRequestDTO;
import com.akata.application.dto.LocationResponseDTO;
import com.akata.application.entities.Location;
import com.akata.application.mappers.LocationMapper;
import com.akata.application.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public LocationResponseDTO save(LocationRequestDTO locationRequestDTO) {
        Location location = this.locationMapper.locationRequestDTOLocation(locationRequestDTO);
        return this.locationMapper.locationToLocationResponseDTO(this.locationRepository.save(location));
    }

    @Override
    public LocationResponseDTO getLocation(Long id) {
        return this.locationMapper.locationToLocationResponseDTO(this.locationRepository.findById(id).get());
    }

    @Override
    public LocationResponseDTO update(Long id, LocationRequestDTO locationRequestDTO) {
        Location location = this.locationMapper.locationRequestDTOLocation(locationRequestDTO);
        location.setId(id);
        return this.locationMapper.locationToLocationResponseDTO(this.locationRepository.save(location));
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.locationRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<LocationResponseDTO> getAllLocation() {
        List<Location> locations = this.locationRepository.findAll();
        return locations.stream().map(location -> this.locationMapper.locationToLocationResponseDTO(location))
                .collect(Collectors.toList());
    }
}
