package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.TicketerPerformerDTO;
import dev.estebangperez.ticket.model.domain.TicketerPerformer;
import dev.estebangperez.ticket.repository.TicketerPerformerRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerPerformerService;
import dev.estebangperez.ticket.util.mappers.TicketerPerformerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TicketerPerformerServiceImpl extends BaseService<TicketerPerformer, Long> implements TicketerPerformerService {
    private final TicketerPerformerRepository performerRepository;

    @Override
    public Set<TicketerPerformerDTO> findByNameContainingIgnoreCase(String name) {
        return TicketerPerformerMapper.mapPerformersFromEntityToDto(performerRepository.findByNameContainingIgnoreCase(name));
    }

    @Override
    protected JpaRepository<TicketerPerformer, Long> getRepository() {
        return performerRepository;
    }
}