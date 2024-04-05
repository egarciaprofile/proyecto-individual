package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketerSeatRepository extends JpaRepository<TicketerSeat, Long> {
}
