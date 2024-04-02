package dev.estebangperez.ticket.model;

import lombok.*;

@Getter
@Setter
@Builder
public class TicketerConcertDTO {
    private TicketerEventDTO event;
    private TicketerPerformerDTO performer;
}
