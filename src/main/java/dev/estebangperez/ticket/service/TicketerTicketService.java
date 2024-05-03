package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerTicketDTO;

import java.util.Set;

public interface TicketerTicketService {
    Set<TicketerTicketDTO> findAllTicketsByUserId(Long userId);
}
