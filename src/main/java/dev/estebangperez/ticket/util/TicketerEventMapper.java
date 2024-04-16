package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerEventDTO;
import dev.estebangperez.ticket.model.domain.TicketerEvent;
import dev.estebangperez.ticket.model.domain.TicketerSeat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketerEventMapper {
    public static TicketerEventDTO toDTO(TicketerEvent event) {
        return TicketerEventDTO.builder()
                .id(event.getId())
                .name(event.getName())
                .eventDate(event.getEventDate())
                .venue(TicketerVenueMapper.toDTO(event.getVenue()))
                .concerts(TicketerConcertMapper.mapConcertsFromEntityToDto(event.getConcerts()))
                .seats(TicketerSeatMapper.mapSeatsFromEntityToDto(event.getSeats()))
                .build();
    }

    public static TicketerEvent fromDTO(TicketerEventDTO dto) {
        return TicketerEvent.builder()
                .id(dto.getId())
                .name(dto.getName())
                .eventDate(dto.getEventDate())
                .venue(TicketerVenueMapper.fromDTO(dto.getVenue()))
                .concerts(TicketerConcertMapper.mapConcertsFromDtoToEntity(dto.getConcerts()))
                .seats(TicketerSeatMapper.mapSeatsFromDtoToEntity(dto.getSeats()))
                .build();
    }

    public static Set<TicketerEventDTO> mapEventsFromEntityToDto(Set<TicketerEvent> events) {
        return events.stream().map(TicketerEventMapper::toDTO).collect(Collectors.toSet());
    }

    public static Set<TicketerEvent> mapEventsFromDtoToEntity(Set<TicketerEventDTO> eventDtos) {
        return eventDtos.stream().map(TicketerEventMapper::fromDTO).collect(Collectors.toSet());
    }
}