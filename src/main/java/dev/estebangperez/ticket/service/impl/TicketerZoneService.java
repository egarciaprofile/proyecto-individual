package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerZone;
import dev.estebangperez.ticket.repository.TicketerZoneRepository;
import dev.estebangperez.ticket.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketerZoneService extends BaseService<TicketerZone, Long> {
    private final TicketerZoneRepository zoneRepository;

    @Override
    protected JpaRepository<TicketerZone, Long> getRepository() {
        return zoneRepository;
    }
}
