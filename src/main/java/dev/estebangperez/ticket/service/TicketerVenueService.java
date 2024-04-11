package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.domain.TicketerVenue;

import java.util.List;

public interface TicketerVenueService {
    List<TicketerVenue> findByCountry(String country);
}
