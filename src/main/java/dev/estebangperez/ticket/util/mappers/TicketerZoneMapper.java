package dev.estebangperez.ticket.util.mappers;

import dev.estebangperez.ticket.model.TicketerZoneDTO;
import dev.estebangperez.ticket.model.domain.TicketerZone;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class TicketerZoneMapper {
    public TicketerZoneDTO toDTO(TicketerZone zone) {
        return TicketerZoneDTO.builder()
                .id(zone.getId())
                .name(zone.getName())
                .description(zone.getDescription())
                .price(zone.getPrice())
                .venue(TicketerVenueMapper.toDTO(zone.getVenue()))
                .build();
    }

    public TicketerZone fromDTO(TicketerZoneDTO dto) {
        return TicketerZone.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .venue(TicketerVenueMapper.fromDTO(dto.getVenue()))
                .build();
    }

    public Set<TicketerZoneDTO> mapZonesFromEntityToDto(Set<TicketerZone> zones) {
        return zones.stream().map(TicketerZoneMapper::toDTO).collect(Collectors.toSet());
    }

    public Set<TicketerZone> mapZonesFromDtoToEntity(Set<TicketerZoneDTO> zoneDtos) {
        return zoneDtos.stream().map(TicketerZoneMapper::fromDTO).collect(Collectors.toSet());
    }
}