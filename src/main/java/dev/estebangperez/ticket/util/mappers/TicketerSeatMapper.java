package dev.estebangperez.ticket.util.mappers;

import dev.estebangperez.ticket.model.TicketerSeatDTO;
import dev.estebangperez.ticket.model.domain.TicketerSeat;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class TicketerSeatMapper {
    public TicketerSeatDTO toDTO(TicketerSeat seat) {
        return TicketerSeatDTO.builder()
                .id(seat.getId())
                .zone(TicketerZoneMapper.toDTO(seat.getZone()))
                .event(TicketerEventMapper.toDTO(seat.getEvent()))
                .build();
    }

    public TicketerSeat fromDTO(TicketerSeatDTO dto) {
        return TicketerSeat.builder()
                .id(dto.getId())
                .zone(TicketerZoneMapper.fromDTO(dto.getZone()))
                .event(TicketerEventMapper.fromDTO(dto.getEvent()))
                .build();
    }

    public Set<TicketerSeatDTO> mapSeatsFromEntityToDto(Set<TicketerSeat> seats) {
        return seats.stream().map(TicketerSeatMapper::toDTO).collect(Collectors.toSet());
    }

    public Set<TicketerSeat> mapSeatsFromDtoToEntity(Set<TicketerSeatDTO> seatDtos) {
        return seatDtos.stream().map(TicketerSeatMapper::fromDTO).collect(Collectors.toSet());
    }
}