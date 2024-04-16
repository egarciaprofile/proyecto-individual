package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TicketerZoneRepository extends JpaRepository<TicketerZone, Long> {
    Set<TicketerZone> findByNameContainingIgnoreCase(String name);
}
