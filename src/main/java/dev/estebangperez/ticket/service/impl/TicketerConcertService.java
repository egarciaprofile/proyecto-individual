package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerConcert;
import dev.estebangperez.ticket.model.domain.TicketerConcert;
import dev.estebangperez.ticket.repository.TicketerConcertRepository;
import dev.estebangperez.ticket.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketerConcertService extends BaseService<TicketerConcert, Long> {

    private final TicketerConcertRepository zoneRepository;

    public TicketerConcertService(TicketerConcertRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    protected JpaRepository<TicketerConcert, Long> getRepository() {
        return zoneRepository;
    }
}
