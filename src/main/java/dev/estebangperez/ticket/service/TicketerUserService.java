package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerUserDTO;
import dev.estebangperez.ticket.model.domain.TicketerUser;

import java.util.Optional;

public interface TicketerUserService {
    Optional<TicketerUserDTO> findByEmail(String email);
}
