package dev.estebangperez.ticket.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
public class TicketerVenueDTO {
    private String name;
    private String location;
    private Integer capacity;
    private Set<TicketerEventDTO> events;
    private Set<TicketerZoneDTO> zones;
}
