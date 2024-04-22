package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.TicketerEventDTO;
import dev.estebangperez.ticket.model.domain.TicketerEvent;
import dev.estebangperez.ticket.repository.TicketerEventRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerEventService;
import dev.estebangperez.ticket.util.TicketerEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class TicketerEventServiceImpl extends BaseService<TicketerEvent, Long> implements TicketerEventService {

    private final TicketerEventRepository eventRepository;

    public Set<TicketerEventDTO> findByEventDate(LocalDate eventDate) {
        return TicketerEventMapper.mapEventsFromEntityToDto(eventRepository.findByEventDate(eventDate));
    }

    public Set<TicketerEventDTO> findAllBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return TicketerEventMapper.mapEventsFromEntityToDto(eventRepository.findAllBetweenDates(startDate, endDate));
    }

    @Override
    protected JpaRepository<TicketerEvent, Long> getRepository() {
        return eventRepository;
    }
}
