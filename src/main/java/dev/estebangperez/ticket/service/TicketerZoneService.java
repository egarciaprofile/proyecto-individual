package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.domain.TicketerZone;

import java.util.List;

public interface TicketerZoneService {
    List<TicketerZone> findByNameContainingIgnoreCase(String name);
}
