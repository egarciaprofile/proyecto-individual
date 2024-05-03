package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerSeatDTO;

import java.util.Set;

public interface TicketerSeatService {
    Set<TicketerSeatDTO> findSeatsByEventId(Long eventId);
}
