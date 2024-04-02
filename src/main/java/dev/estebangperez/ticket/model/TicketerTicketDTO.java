package dev.estebangperez.ticket.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TicketerTicketDTO {
    private TicketerUserDTO user;
    private TicketerConcertDTO concert;
    private TicketerSeatDTO seat;
    private LocalDateTime purchaseDate;
}