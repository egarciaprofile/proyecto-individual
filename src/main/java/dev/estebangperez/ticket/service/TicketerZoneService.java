package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerZoneDTO;
import dev.estebangperez.ticket.model.domain.TicketerZone;

import java.util.List;
import java.util.Set;

public interface TicketerZoneService {
    Set<TicketerZoneDTO> findByNameContainingIgnoreCase(String name);

    Set<TicketerZoneDTO> findAllByVenueId(Long venueId);
}
