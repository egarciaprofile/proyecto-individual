package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerTicket;
import dev.estebangperez.ticket.repository.TicketerTicketRepository;
import dev.estebangperez.ticket.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketerTicketService extends BaseService<TicketerTicket, Long> {

    private final TicketerTicketRepository ticketRepository;

    @Override
    protected JpaRepository<TicketerTicket, Long> getRepository() {
        return ticketRepository;
    }
}
