package dev.estebangperez.ticket.util.mappers;

import dev.estebangperez.ticket.model.TicketerConcertDTO;
import dev.estebangperez.ticket.model.domain.TicketerConcert;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class TicketerConcertMapper {
    public TicketerConcertDTO toDTO(TicketerConcert concert) {
        return TicketerConcertDTO.builder()
                .id(concert.getId())
                .event(TicketerEventMapper.toDTO(concert.getEvent()))
                .performer(TicketerPerformerMapper.toDTO(concert.getPerformer()))
                .build();
    }

    public TicketerConcert fromDTO(TicketerConcertDTO dto) {
        return TicketerConcert.builder()
                .id(dto.getId())
                .event(TicketerEventMapper.fromDTO(dto.getEvent()))
                .performer(TicketerPerformerMapper.fromDTO(dto.getPerformer()))
                .build();
    }

    public Set<TicketerConcertDTO> mapConcertsFromEntityToDto(Set<TicketerConcert> concerts) {
        return concerts.stream().map(TicketerConcertMapper::toDTO).collect(Collectors.toSet());
    }

    public Set<TicketerConcert> mapConcertsFromDtoToEntity(Set<TicketerConcertDTO> concertDtos) {
        return concertDtos.stream().map(TicketerConcertMapper::fromDTO).collect(Collectors.toSet());
    }
}