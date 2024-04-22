package dev.estebangperez.ticket.model;

import lombok.*;

@Getter
@Setter
@Builder
public class TicketerSeatDTO {
    private Long id;
    private TicketerZoneDTO zone;
    private TicketerTicketDTO ticket;
}