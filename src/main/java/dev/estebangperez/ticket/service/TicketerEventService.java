package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerEventDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface TicketerEventService {
    Set<TicketerEventDTO> findByEventDate(LocalDate eventDate);
    Set<TicketerEventDTO> findAllBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}
