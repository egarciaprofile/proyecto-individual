package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.domain.TicketerPerformer;

import java.util.List;

public interface TicketerPerformerService {
    List<TicketerPerformer> findByNameContainingIgnoreCase(String name);
}
