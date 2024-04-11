package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketerZoneRepository extends JpaRepository<TicketerZone, Long> {
}
