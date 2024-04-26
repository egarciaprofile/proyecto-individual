package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerTicketDTO;
import dev.estebangperez.ticket.model.domain.TicketerTicket;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketerTicketMapper {
    public static TicketerTicketDTO toDTO(TicketerTicket ticket) {
        return TicketerTicketDTO.builder()
                .id(ticket.getId())
                .user(TicketerUserMapper.toDTO(ticket.getUser()))
                .concert(TicketerConcertMapper.toDTO(ticket.getConcert()))
                .seat(TicketerSeatMapper.toDTO(ticket.getSeat()))
                .purchaseDate(ticket.getPurchaseDate())
                .build();
    }

    public static TicketerTicket fromDTO(TicketerTicketDTO dto) {
        return TicketerTicket.builder()
                .id(dto.getId())
                .user(TicketerUserMapper.fromDTO(dto.getUser()))
                .concert(TicketerConcertMapper.fromDTO(dto.getConcert()))
                .seat(TicketerSeatMapper.fromDTO(dto.getSeat()))
                .purchaseDate(dto.getPurchaseDate())
                .build();
    }

    public static Set<TicketerTicketDTO> mapTicketsFromEntityToDto(Set<TicketerTicket> tickets) {
        return tickets.stream().map(TicketerTicketMapper::toDTO).collect(Collectors.toSet());
    }

    public static List<Long> mapTicketsFromEntityToDtoId(Set<TicketerTicket> tickets) {
        return tickets.stream().map(TicketerTicket::getId).collect(Collectors.toList());
    }

    public static Set<TicketerTicket> mapTicketsFromDtoToEntity(Set<TicketerTicketDTO> ticketDtos) {
        return ticketDtos.stream().map(TicketerTicketMapper::fromDTO).collect(Collectors.toSet());
    }
}