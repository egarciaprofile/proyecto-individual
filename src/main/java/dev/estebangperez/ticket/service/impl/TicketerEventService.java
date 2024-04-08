package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerEvent;
import dev.estebangperez.ticket.repository.TicketerEventRepository;
import dev.estebangperez.ticket.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TicketerEventService extends BaseService<TicketerEvent, Long> {

    private final TicketerEventRepository eventRepository;

    @Override
    protected JpaRepository<TicketerEvent, Long> getRepository() {
        return eventRepository;
    }
}
