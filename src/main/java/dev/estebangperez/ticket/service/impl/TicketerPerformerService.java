package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerPerformer;
import dev.estebangperez.ticket.repository.TicketerPerformerRepository;
import dev.estebangperez.ticket.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketerPerformerService extends BaseService<TicketerPerformer, Long> {

    private final TicketerPerformerRepository performerRepository;

    public TicketerPerformerService(TicketerPerformerRepository performerRepository) {
        this.performerRepository = performerRepository;
    }

    @Override
    protected JpaRepository<TicketerPerformer, Long> getRepository() {
        return performerRepository;
    }
}