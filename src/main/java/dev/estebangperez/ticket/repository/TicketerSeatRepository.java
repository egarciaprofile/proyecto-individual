package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TicketerSeatRepository extends JpaRepository<TicketerSeat, Long> {
    @Query("SELECT s FROM TicketerSeat s WHERE s.event.id = :eventId")
    Set<TicketerSeat> findSeatsByEventId(Long eventId);
}
