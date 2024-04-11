package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.domain.TicketerEvent;

import java.util.List;

public interface TicketerPerformerService {
    List<TicketerEvent> findByNameContainingIgnoreCase(String name);
}
