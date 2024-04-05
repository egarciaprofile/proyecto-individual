package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerUser;
import dev.estebangperez.ticket.model.domain.TicketerUser;
import dev.estebangperez.ticket.repository.TicketerUserRepository;
import dev.estebangperez.ticket.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketerUserService extends BaseService<TicketerUser, Long> {

    private final TicketerUserRepository userRepository;

    public TicketerUserService(TicketerUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<TicketerUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    protected JpaRepository<TicketerUser, Long> getRepository() {
        return userRepository;
    }
}
