package dev.estebangperez.ticket.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketerConcertDTO {
    private Long id;
    private TicketerEventDTO event;
    private TicketerPerformerDTO performer;
}
