package dev.estebangperez.ticket.model;

import lombok.*;

@Getter
@Setter
@Builder
public class TicketerConcertDTO {
    private Long id;
    private TicketerEventDTO event;
    private TicketerPerformerDTO performer;
}
