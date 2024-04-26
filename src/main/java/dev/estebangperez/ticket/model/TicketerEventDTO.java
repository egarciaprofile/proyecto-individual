package dev.estebangperez.ticket.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TicketerEventDTO {
    private Long id;
    private String name;
    private LocalDateTime eventDate;
    private TicketerVenueDTO venue;
}