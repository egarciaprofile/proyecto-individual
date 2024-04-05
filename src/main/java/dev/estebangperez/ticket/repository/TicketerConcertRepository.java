package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerConcert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketerConcertRepository extends JpaRepository<TicketerConcert, Long> {
}
