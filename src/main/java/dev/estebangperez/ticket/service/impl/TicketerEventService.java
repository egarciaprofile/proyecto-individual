package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerEvent;
import dev.estebangperez.ticket.repository.TicketerEventRepository;
import dev.estebangperez.ticket.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class TicketerEventService extends BaseService<TicketerEvent, Long> {

    private final TicketerEventRepository eventRepository;

    public TicketerEventService(TicketerEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    protected JpaRepository<TicketerEvent, Long> getRepository() {
        return eventRepository;
    }
}
