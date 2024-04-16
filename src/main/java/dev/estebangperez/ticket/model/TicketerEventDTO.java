package dev.estebangperez.ticket.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
public class TicketerEventDTO {
    private Long id;
    private String name;
    private LocalDateTime eventDate;
    private TicketerVenueDTO venue;
    private Set<TicketerConcertDTO> concerts;
    private Set<TicketerSeatDTO> seats;
}