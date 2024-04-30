package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.TicketerTicketDTO;
import dev.estebangperez.ticket.model.domain.TicketerTicket;
import dev.estebangperez.ticket.repository.TicketerTicketRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerTicketService;
import dev.estebangperez.ticket.util.mappers.TicketerTicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TicketerTicketServiceImpl extends BaseService<TicketerTicket, Long> implements TicketerTicketService {

    private final TicketerTicketRepository ticketRepository;

    @Override
    public Set<TicketerTicketDTO> findAllTicketsByUserId(Long userId) {
        return TicketerTicketMapper.mapTicketsFromEntityToDto(ticketRepository.findAllTicketsByUserId(userId));
    }

    @Override
    protected JpaRepository<TicketerTicket, Long> getRepository() {
        return ticketRepository;
    }
}
