package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface TicketerEventRepository extends JpaRepository<TicketerEvent, Long> {
    @Query("SELECT e FROM TicketerEvent e WHERE FUNCTION('DATE', e.eventDate) = :eventDate")
    Set<TicketerEvent> findByEventDate(@Param("eventDate") LocalDate eventDate);

    @Query("SELECT e FROM TicketerEvent e WHERE e.eventDate BETWEEN :startDate AND :endDate")
    Set<TicketerEvent> findAllBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
