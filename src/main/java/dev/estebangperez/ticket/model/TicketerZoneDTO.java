package dev.estebangperez.ticket.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class TicketerZoneDTO {
    private Long id;
    private String name;
    private String description;
    private TicketerVenueDTO venue;
    private BigDecimal price;
}