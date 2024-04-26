package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerPerformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TicketerPerformerRepository extends JpaRepository<TicketerPerformer, Long> {
    Set<TicketerPerformer> findByNameContainingIgnoreCase(String name);
}
