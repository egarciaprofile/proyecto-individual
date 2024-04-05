package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerVenue;
import dev.estebangperez.ticket.repository.TicketerVenueRepository;
import dev.estebangperez.ticket.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketerVenueService extends BaseService<TicketerVenue, Long> {

    private final TicketerVenueRepository venueRepository;

    public TicketerVenueService(TicketerVenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    protected JpaRepository<TicketerVenue, Long> getRepository() {
        return venueRepository;
    }
}