package dev.estebangperez.ticket.model;

import dev.estebangperez.ticket.model.domain.TicketerEvent;
import lombok.*;

@Getter
@Setter
@Builder
public class TicketerSeatDTO {
    private Long id;
    private TicketerZoneDTO zone;
    private TicketerEventDTO event;
}