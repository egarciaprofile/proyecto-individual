package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.domain.TicketerUser;

import java.util.Optional;

public interface TicketerUserService {
    Optional<TicketerUser> findByEmail(String email);
}
