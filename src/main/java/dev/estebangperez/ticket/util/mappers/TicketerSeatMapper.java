package dev.estebangperez.ticket.util.mappers;

import dev.estebangperez.ticket.model.TicketerSeatDTO;
import dev.estebangperez.ticket.model.domain.TicketerSeat;

import java.util.Set;
import java.util.stream.Collectors;

public class TicketerSeatMapper {
    public static TicketerSeatDTO toDTO(TicketerSeat seat) {
        return TicketerSeatDTO.builder()
                .id(seat.getId())
                .zone(TicketerZoneMapper.toDTO(seat.getZone()))
                .event(TicketerEventMapper.toDTO(seat.getEvent()))
                .build();
    }

    public static TicketerSeat fromDTO(TicketerSeatDTO dto) {
        return TicketerSeat.builder()
                .id(dto.getId())
                .zone(TicketerZoneMapper.fromDTO(dto.getZone()))
                .event(TicketerEventMapper.fromDTO(dto.getEvent()))
                .build();
    }

    public static Set<TicketerSeatDTO> mapSeatsFromEntityToDto(Set<TicketerSeat> seats) {
        return seats.stream().map(TicketerSeatMapper::toDTO).collect(Collectors.toSet());
    }

    public static Set<TicketerSeat> mapSeatsFromDtoToEntity(Set<TicketerSeatDTO> seatDtos) {
        return seatDtos.stream().map(TicketerSeatMapper::fromDTO).collect(Collectors.toSet());
    }
}