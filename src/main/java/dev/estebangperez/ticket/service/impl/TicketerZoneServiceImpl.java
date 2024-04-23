package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.TicketerZoneDTO;
import dev.estebangperez.ticket.model.domain.TicketerZone;
import dev.estebangperez.ticket.repository.TicketerZoneRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerZoneService;
import dev.estebangperez.ticket.util.TicketerZoneMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TicketerZoneServiceImpl extends BaseService<TicketerZone, Long> implements TicketerZoneService {
    private final TicketerZoneRepository zoneRepository;

    @Override
    public Set<TicketerZoneDTO> findByNameContainingIgnoreCase(String name) {
        return TicketerZoneMapper.mapZonesFromEntityToDto(zoneRepository.findByNameContainingIgnoreCase(name));
    }

    @Override
    public Set<TicketerZoneDTO> findAllByVenueId(Long venueId) {
        return TicketerZoneMapper.mapZonesFromEntityToDto(zoneRepository.findAllByVenueId(venueId));
    }

    @Override
    protected JpaRepository<TicketerZone, Long> getRepository() {
        return zoneRepository;
    }
}
