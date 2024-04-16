package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerConcert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TicketerConcertRepository extends JpaRepository<TicketerConcert, Long> {
    @Query("SELECT c FROM TicketerConcert c WHERE c.performer.name = :performerName")
    Set<TicketerConcert> findByPerformerName(@Param("performerName") String performerName);

    @Query("SELECT c FROM TicketerConcert c WHERE LOWER(c.performer.name) LIKE LOWER(CONCAT('%', :performerName, '%'))")
    Set<TicketerConcert> findByPerformerNameContainingIgnoreCase(@Param("performerName") String performerName);
}
