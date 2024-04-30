package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.TicketerSeatDTO;
import dev.estebangperez.ticket.model.domain.TicketerSeat;
import dev.estebangperez.ticket.repository.TicketerSeatRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerSeatService;
import dev.estebangperez.ticket.util.mappers.TicketerSeatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TicketerSeatServiceImpl extends BaseService<TicketerSeat, Long> implements TicketerSeatService {

    private final TicketerSeatRepository seatRepository;

    @Override
    public Set<TicketerSeatDTO> findSeatsByEventId(Long eventId) {
        return TicketerSeatMapper.mapSeatsFromEntityToDto(seatRepository.findSeatsByEventId(eventId));
    }

    @Override
    protected JpaRepository<TicketerSeat, Long> getRepository() {
        return seatRepository;
    }
}
