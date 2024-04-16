package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerZoneDTO;
import dev.estebangperez.ticket.model.domain.TicketerZone;

import java.util.ArrayList;
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
                .seats(TicketerSeatMapper.mapSeatsFromEntityToDto(zone.getSeats()))
                .build();
    }

    public static TicketerZone fromDTO(TicketerZoneDTO dto) {
        return TicketerZone.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .seats(TicketerSeatMapper.mapSeatsFromDtoToEntity(dto.getSeats()))
                .build();
    }

    public static Set<TicketerZoneDTO> mapZonesFromEntityToDto(Set<TicketerZone> zones) {
        return zones.stream().map(TicketerZoneMapper::toDTO).collect(Collectors.toSet());
    }

    public static Set<TicketerZone> mapZonesFromDtoToEntity(Set<TicketerZoneDTO> zoneDtos) {
        return zoneDtos.stream().map(TicketerZoneMapper::fromDTO).collect(Collectors.toSet());
    }
}