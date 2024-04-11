package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerUser;
import dev.estebangperez.ticket.repository.TicketerUserRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketerUserServiceImpl extends BaseService<TicketerUser, Long> implements TicketerUserService {

    private final TicketerUserRepository userRepository;

    public Optional<TicketerUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    protected JpaRepository<TicketerUser, Long> getRepository() {
        return userRepository;
    }
}
