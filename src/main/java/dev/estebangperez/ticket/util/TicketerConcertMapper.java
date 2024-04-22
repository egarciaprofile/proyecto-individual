package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerConcertDTO;
import dev.estebangperez.ticket.model.domain.TicketerConcert;

import java.util.Set;
import java.util.stream.Collectors;

public class TicketerConcertMapper {
    public static TicketerConcertDTO toDTO(TicketerConcert concert) {
        return TicketerConcertDTO.builder()
                .id(concert.getId())
                .event(TicketerEventMapper.toDTO(concert.getEvent()))
                .performer(TicketerPerformerMapper.toDTO(concert.getPerformer()))
                .build();
    }

    public static TicketerConcert fromDTO(TicketerConcertDTO dto) {
        return TicketerConcert.builder()
                .id(dto.getId())
                .event(TicketerEventMapper.fromDTO(dto.getEvent()))
                .performer(TicketerPerformerMapper.fromDTO(dto.getPerformer()))
                .build();
    }

    public static Set<TicketerConcertDTO> mapConcertsFromEntityToDto(Set<TicketerConcert> concerts) {
        return concerts.stream().map(TicketerConcertMapper::toDTO).collect(Collectors.toSet());
    }

    public static Set<TicketerConcert> mapConcertsFromDtoToEntity(Set<TicketerConcertDTO> concertDtos) {
        return concertDtos.stream().map(TicketerConcertMapper::fromDTO).collect(Collectors.toSet());
    }
}