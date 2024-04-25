package dev.estebangperez.ticket.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketerVenueDTO {
    private Long id;
    private String name;
    private String city;
    private String country;
    private String address;
    private Integer capacity;
}
