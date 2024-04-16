package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerSeatDTO;
import dev.estebangperez.ticket.model.domain.TicketerSeat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketerSeatMapper {
    public static TicketerSeatDTO toDTO(TicketerSeat seat) {
        return TicketerSeatDTO.builder()
                .id(seat.getId())
                .zone(TicketerZoneMapper.toDTO(seat.getZone()))
                .ticket(TicketerTicketMapper.toDTO(seat.getTicket()))
                .build();
    }

    public static TicketerSeat fromDTO(TicketerSeatDTO dto) {
        return TicketerSeat.builder()
                .id(dto.getId())
                .zone(TicketerZoneMapper.fromDTO(dto.getZone()))
                .ticket(TicketerTicketMapper.fromDTO(dto.getTicket()))
                .build();
    }

    public static Set<TicketerSeatDTO> mapSeatsFromEntityToDto(Set<TicketerSeat> seats) {
        return seats.stream().map(TicketerSeatMapper::toDTO).collect(Collectors.toSet());
    }

    public static Set<TicketerSeat> mapSeatsFromDtoToEntity(Set<TicketerSeatDTO> seatDtos) {
        return seatDtos.stream().map(TicketerSeatMapper::fromDTO).collect(Collectors.toSet());
    }
}