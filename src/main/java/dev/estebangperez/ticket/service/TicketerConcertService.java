package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.domain.TicketerConcert;

import java.util.List;

public interface TicketerConcertService {
    List<TicketerConcert> findByPerformerName(String performerName);
    List<TicketerConcert> findByPerformerNameContainingIgnoreCase(String performerName);
}
