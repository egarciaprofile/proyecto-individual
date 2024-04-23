package dev.estebangperez.ticket.model;

import jakarta.persistence.Column;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class TicketerVenueDTO {
    private Long id;
    private String name;
    private String location;
    private String city;
    private String country;
    private String address;
    private List<Long> events;
    private List<Long> zones;
}
