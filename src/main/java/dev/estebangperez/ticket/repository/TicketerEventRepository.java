package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketerEventRepository extends JpaRepository<TicketerEvent, Long> {
}
