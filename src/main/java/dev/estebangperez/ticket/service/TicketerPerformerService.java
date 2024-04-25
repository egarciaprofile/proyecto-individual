package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerPerformerDTO;

import java.util.Set;

public interface TicketerPerformerService {
    Set<TicketerPerformerDTO> findByNameContainingIgnoreCase(String name);
}
