package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.TicketerConcertDTO;
import dev.estebangperez.ticket.model.domain.TicketerConcert;
import dev.estebangperez.ticket.repository.TicketerConcertRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerConcertService;
import dev.estebangperez.ticket.util.TicketerConcertMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TicketerConcertServiceImpl extends BaseService<TicketerConcert, Long> implements TicketerConcertService {

    private final TicketerConcertRepository concertRepository;

    public Set<TicketerConcertDTO> findByPerformerName(String performerName) {
        return TicketerConcertMapper.mapConcertsFromEntityToDto(concertRepository.findByPerformerName(performerName));
    }

    public Set<TicketerConcertDTO> findByPerformerNameContainingIgnoreCase(String performerName) {
        return TicketerConcertMapper.mapConcertsFromEntityToDto(concertRepository.findByPerformerNameContainingIgnoreCase(performerName));
    }

    @Override
    protected JpaRepository<TicketerConcert, Long> getRepository() {
        return concertRepository;
    }
}
