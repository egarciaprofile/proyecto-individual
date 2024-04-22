package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerVenueDTO;
import dev.estebangperez.ticket.model.domain.TicketerVenue;

import java.util.List;
import java.util.Set;

public interface TicketerVenueService {
    Set<TicketerVenueDTO> findByCountry(String country);
}
