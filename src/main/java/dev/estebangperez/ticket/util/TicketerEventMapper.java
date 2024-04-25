package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerEventDTO;
import dev.estebangperez.ticket.model.domain.TicketerConcert;
import dev.estebangperez.ticket.model.domain.TicketerEvent;

import java.util.HashSet;
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
                .build();
    }

    public static TicketerEvent fromDTO(TicketerEventDTO dto) {
        return TicketerEvent.builder()
                .id(dto.getId())
                .name(dto.getName())
                .eventDate(dto.getEventDate())
                .venue(TicketerVenueMapper.fromDTO(dto.getVenue()))
                .build();
    }

    public static Set<TicketerEventDTO> mapEventsFromEntityToDto(Set<TicketerEvent> events) {
        return events.stream().map(TicketerEventMapper::toDTO).collect(Collectors.toSet());
    }

    public static List<Long> mapEventsFromEntityToDtoId(Set<TicketerEvent> events) {
        return events.stream().map(TicketerEvent::getId).collect(Collectors.toList());
    }

    public static Set<TicketerEvent> mapEventsFromDtoToEntity(Set<TicketerEventDTO> eventDtos) {
        return eventDtos.stream().map(TicketerEventMapper::fromDTO).collect(Collectors.toSet());
    }
}