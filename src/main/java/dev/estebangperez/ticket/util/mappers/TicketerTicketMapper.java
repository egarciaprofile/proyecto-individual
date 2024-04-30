package dev.estebangperez.ticket.util.mappers;

import dev.estebangperez.ticket.model.TicketerTicketDTO;
import dev.estebangperez.ticket.model.domain.TicketerTicket;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class TicketerTicketMapper {
    public TicketerTicketDTO toDTO(TicketerTicket ticket) {
        return TicketerTicketDTO.builder()
                .id(ticket.getId())
                .user(TicketerUserMapper.toDTO(ticket.getUser()))
                .concert(TicketerConcertMapper.toDTO(ticket.getConcert()))
                .seat(TicketerSeatMapper.toDTO(ticket.getSeat()))
                .purchaseDate(ticket.getPurchaseDate())
                .build();
    }

    public TicketerTicket fromDTO(TicketerTicketDTO dto) {
        return TicketerTicket.builder()
                .id(dto.getId())
                .user(TicketerUserMapper.fromDTO(dto.getUser()))
                .concert(TicketerConcertMapper.fromDTO(dto.getConcert()))
                .seat(TicketerSeatMapper.fromDTO(dto.getSeat()))
                .purchaseDate(dto.getPurchaseDate())
                .build();
    }

    public Set<TicketerTicketDTO> mapTicketsFromEntityToDto(Set<TicketerTicket> tickets) {
        return tickets.stream().map(TicketerTicketMapper::toDTO).collect(Collectors.toSet());
    }

    public Set<TicketerTicket> mapTicketsFromDtoToEntity(Set<TicketerTicketDTO> ticketDtos) {
        return ticketDtos.stream().map(TicketerTicketMapper::fromDTO).collect(Collectors.toSet());
    }
}