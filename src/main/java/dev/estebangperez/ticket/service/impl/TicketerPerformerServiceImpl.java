package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerEvent;
import dev.estebangperez.ticket.model.domain.TicketerPerformer;
import dev.estebangperez.ticket.repository.TicketerPerformerRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerPerformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketerPerformerServiceImpl extends BaseService<TicketerPerformer, Long> implements TicketerPerformerService {
    private final TicketerPerformerRepository performerRepository;

    public List<TicketerEvent> findByNameContainingIgnoreCase(String name) {
        return performerRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    protected JpaRepository<TicketerPerformer, Long> getRepository() {
        return performerRepository;
    }
}