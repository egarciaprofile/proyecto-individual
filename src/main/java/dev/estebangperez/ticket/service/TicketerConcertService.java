package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerConcertDTO;

import java.util.Set;

public interface TicketerConcertService {
    Set<TicketerConcertDTO> findByPerformerName(String performerName);

    Set<TicketerConcertDTO> findByPerformerNameContainingIgnoreCase(String performerName);
}
