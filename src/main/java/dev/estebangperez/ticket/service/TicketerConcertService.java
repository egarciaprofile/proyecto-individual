package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerConcertDTO;
import dev.estebangperez.ticket.model.domain.TicketerConcert;

import java.util.Set;

public interface TicketerConcertService {
    Set<TicketerConcertDTO> findByPerformerName(String performerName);
    Set<TicketerConcertDTO> findByPerformerNameContainingIgnoreCase(String performerName);
}
