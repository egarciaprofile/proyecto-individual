package dev.estebangperez.ticket.model;

import dev.estebangperez.ticket.model.domain.TicketerVenue;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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