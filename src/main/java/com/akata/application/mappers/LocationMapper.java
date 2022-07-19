package com.akata.application.mappers;

import com.akata.application.dto.LocationRequestDTO;
import com.akata.application.dto.LocationResponseDTO;
import com.akata.application.entities.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationResponseDTO locationToLocationResponseDTO(Location location);
    Location locationRequestDTOLocation (LocationRequestDTO locationRequestDTO);

    Location locationResponseToLocation(LocationResponseDTO locationResponseDTO);
}
