package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerVenueDTO;

import java.util.Set;

public interface TicketerVenueService {
    Set<TicketerVenueDTO> findByCountry(String country);
}
