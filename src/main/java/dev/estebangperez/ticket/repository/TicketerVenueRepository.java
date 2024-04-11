package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerVenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketerVenueRepository extends JpaRepository<TicketerVenue, Long> {
    List<TicketerVenue> findByCountry(String country);
}
