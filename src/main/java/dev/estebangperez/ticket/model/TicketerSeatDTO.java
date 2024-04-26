package dev.estebangperez.ticket.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketerSeatDTO {
    private Long id;
    private TicketerZoneDTO zone;
    private TicketerEventDTO event;
}