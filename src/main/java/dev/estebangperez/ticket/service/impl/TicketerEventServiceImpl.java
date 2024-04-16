package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerEvent;
import dev.estebangperez.ticket.repository.TicketerEventRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TicketerEventServiceImpl extends BaseService<TicketerEvent, Long> implements TicketerEventService {

    private final TicketerEventRepository eventRepository;

    public List<TicketerEvent> findByEventDate(LocalDate eventDate) {
        return eventRepository.findByEventDate(eventDate);
    }

    public List<TicketerEvent> findAllBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return eventRepository.findAllBetweenDates(startDate, endDate);
    }

    @Override
    protected JpaRepository<TicketerEvent, Long> getRepository() {
        return eventRepository;
    }
}
