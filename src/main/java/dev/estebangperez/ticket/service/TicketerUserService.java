package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerUserDTO;

import java.util.Optional;

public interface TicketerUserService {
    Optional<TicketerUserDTO> findByEmail(String email);
}
