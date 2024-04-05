package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerVenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketerVenueRepository extends JpaRepository<TicketerVenue, Long> {
}
