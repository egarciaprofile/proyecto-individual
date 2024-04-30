package dev.estebangperez.ticket.util.mappers;

import dev.estebangperez.ticket.model.TicketerEventDTO;
import dev.estebangperez.ticket.model.domain.TicketerEvent;

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

    public static Set<TicketerEvent> mapEventsFromDtoToEntity(Set<TicketerEventDTO> eventDtos) {
        return eventDtos.stream().map(TicketerEventMapper::fromDTO).collect(Collectors.toSet());
    }
}