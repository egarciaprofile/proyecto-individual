package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TicketerZoneRepository extends JpaRepository<TicketerZone, Long> {
    Set<TicketerZone> findByNameContainingIgnoreCase(String name);

    @Query("SELECT z FROM TicketerZone z WHERE z.venue.id = :venueId")
    Set<TicketerZone> findAllByVenueId(Long venueId);
}
