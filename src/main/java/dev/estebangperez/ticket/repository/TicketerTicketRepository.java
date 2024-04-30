package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TicketerTicketRepository extends JpaRepository<TicketerTicket, Long> {
    @Query("SELECT t FROM TicketerTicket t WHERE t.user.id = :userId")
    Set<TicketerTicket> findAllTicketsByUserId(Long userId);
}