package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerZoneDTO;
import dev.estebangperez.ticket.model.domain.TicketerZone;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketerZoneMapper {
    public static TicketerZoneDTO toDTO(TicketerZone zone) {
        return TicketerZoneDTO.builder()
                .id(zone.getId())
                .name(zone.getName())
                .description(zone.getDescription())
                .price(zone.getPrice())
                .venue(TicketerVenueMapper.toDTO(zone.getVenue()))
                .build();
    }

    public static TicketerZone fromDTO(TicketerZoneDTO dto) {
        return TicketerZone.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .venue(TicketerVenueMapper.fromDTO(dto.getVenue()))
                .build();
    }

    public static Set<TicketerZoneDTO> mapZonesFromEntityToDto(Set<TicketerZone> zones) {
        return zones.stream().map(TicketerZoneMapper::toDTO).collect(Collectors.toSet());
    }

    public static List<Long> mapZonesFromEntityToDtoId(Set<TicketerZone> zones) {
        return zones.stream().map(TicketerZone::getId).collect(Collectors.toList());
    }

    public static Set<TicketerZone> mapZonesFromDtoToEntity(Set<TicketerZoneDTO> zoneDtos) {
        return zoneDtos.stream().map(TicketerZoneMapper::fromDTO).collect(Collectors.toSet());
    }
}