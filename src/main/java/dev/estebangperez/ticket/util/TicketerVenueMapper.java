package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerVenueDTO;
import dev.estebangperez.ticket.model.domain.TicketerVenue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketerVenueMapper {
    public static TicketerVenueDTO toDTO(TicketerVenue venue) {
        return TicketerVenueDTO.builder()
                .id(venue.getId())
                .name(venue.getName())
                .city(venue.getCity())
                .country(venue.getCountry())
                .address(venue.getAddress())
                .events(TicketerEventMapper.mapEventsFromEntityToDto(venue.getEvents()))
                .zones(TicketerZoneMapper.mapZonesFromEntityToDto(venue.getZones()))
                .build();
    }

    public static TicketerVenue fromDTO(TicketerVenueDTO dto) {
        return TicketerVenue.builder()
                .id(dto.getId())
                .name(dto.getName())
                .city(dto.getCity())
                .country(dto.getCountry())
                .address(dto.getAddress())
                .events(TicketerEventMapper.mapEventsFromDtoToEntity(dto.getEvents()))
                .zones(TicketerZoneMapper.mapZonesFromDtoToEntity(dto.getZones()))
                .build();
    }

    public static List<TicketerVenueDTO> mapVenuesFromEntityToDto(List<TicketerVenue> venues) {
        return venues.stream().map(TicketerVenueMapper::toDTO).collect(Collectors.toList());
    }

    public static List<TicketerVenue> mapVenuesFromDtoToEntity(List<TicketerVenueDTO> venueDtos) {
        return venueDtos.stream().map(TicketerVenueMapper::fromDTO).collect(Collectors.toList());
    }
}