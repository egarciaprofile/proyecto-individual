package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.domain.TicketerVenue;
import dev.estebangperez.ticket.repository.TicketerVenueRepository;
import dev.estebangperez.ticket.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketerVenueServiceImpl extends BaseService<TicketerVenue, Long> {

    private final TicketerVenueRepository venueRepository;

    public List<TicketerVenue> findByCountry(String country) {
        return venueRepository.findByCountry(country);
    }

    @Override
    protected JpaRepository<TicketerVenue, Long> getRepository() {
        return venueRepository;
    }
}