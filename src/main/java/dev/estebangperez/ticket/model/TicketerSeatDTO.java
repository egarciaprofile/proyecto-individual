package dev.estebangperez.ticket.model;

import lombok.*;

@Getter
@Setter
@Builder
public class TicketerSeatDTO {
    private TicketerZoneDTO zone;
    private TicketerTicketDTO ticket;
}