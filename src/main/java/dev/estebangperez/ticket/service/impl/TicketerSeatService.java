package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerSeat;
import dev.estebangperez.ticket.repository.TicketerSeatRepository;
import dev.estebangperez.ticket.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketerSeatService extends BaseService<TicketerSeat, Long> {

    private final TicketerSeatRepository seatRepository;

    @Override
    protected JpaRepository<TicketerSeat, Long> getRepository() {
        return seatRepository;
    }
}
