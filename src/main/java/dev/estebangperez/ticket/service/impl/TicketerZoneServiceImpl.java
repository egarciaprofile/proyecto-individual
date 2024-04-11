package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerZone;
import dev.estebangperez.ticket.repository.TicketerZoneRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketerZoneServiceImpl extends BaseService<TicketerZone, Long> implements TicketerZoneService {
    private final TicketerZoneRepository zoneRepository;

    public List<TicketerZone> findByNameContainingIgnoreCase(String name) {
        return zoneRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    protected JpaRepository<TicketerZone, Long> getRepository() {
        return zoneRepository;
    }
}
