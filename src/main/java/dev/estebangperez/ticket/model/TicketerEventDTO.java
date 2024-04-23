package dev.estebangperez.ticket.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class TicketerEventDTO {
    private Long id;
    private String name;
    private LocalDateTime eventDate;
    private TicketerVenueDTO venue;
    private List<Long> concerts;
    private List<Long> seats;
}