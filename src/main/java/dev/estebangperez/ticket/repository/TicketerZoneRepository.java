package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketerZoneRepository extends JpaRepository<TicketerZone, Long> {
    List<TicketerZone> findByNameContainingIgnoreCase(String name);
}
