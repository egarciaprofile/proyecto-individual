package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerConcert;
import dev.estebangperez.ticket.repository.TicketerConcertRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketerConcertServiceImpl extends BaseService<TicketerConcert, Long> implements TicketerConcertService {

    private final TicketerConcertRepository concertRepository;

    public List<TicketerConcert> findByPerformerName(String performerName) {
        return concertRepository.findByPerformerName(performerName);
    }

    public List<TicketerConcert> findByPerformerNameContainingIgnoreCase(String performerName) {
        return concertRepository.findByPerformerNameContainingIgnoreCase(performerName);
    }

    @Override
    protected JpaRepository<TicketerConcert, Long> getRepository() {
        return concertRepository;
    }
}
