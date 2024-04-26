package dev.estebangperez.ticket.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TicketerTicketDTO {
    private Long id;
    private TicketerUserDTO user;
    private TicketerConcertDTO concert;
    private TicketerSeatDTO seat;
    private LocalDateTime purchaseDate;
}