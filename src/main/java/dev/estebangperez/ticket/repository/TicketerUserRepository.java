package dev.estebangperez.ticket.repository;

import dev.estebangperez.ticket.model.domain.TicketerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketerUserRepository extends JpaRepository<TicketerUser, Long> {
}
