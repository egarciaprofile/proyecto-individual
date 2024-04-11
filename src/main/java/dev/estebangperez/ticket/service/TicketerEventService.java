package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.domain.TicketerEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketerEventService {
    List<TicketerEvent> findByEventDate(LocalDate eventDate);
    List<TicketerEvent> findAllBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}
