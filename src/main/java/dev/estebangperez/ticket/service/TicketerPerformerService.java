package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerPerformerDTO;
import dev.estebangperez.ticket.model.domain.TicketerPerformer;

import java.util.List;
import java.util.Set;

public interface TicketerPerformerService {
    Set<TicketerPerformerDTO> findByNameContainingIgnoreCase(String name);
}
