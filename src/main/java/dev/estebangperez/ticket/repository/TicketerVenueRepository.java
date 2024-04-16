package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerVenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TicketerVenueRepository extends JpaRepository<TicketerVenue, Long> {
    Set<TicketerVenue> findByCountry(String country);
}
