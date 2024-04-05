package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketerTicketRepository extends JpaRepository<TicketerTicket, Long> {
}