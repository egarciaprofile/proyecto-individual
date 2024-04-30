package dev.estebangperez.ticket.service.impl;

import dev.estebangperez.ticket.model.TicketerVenueDTO;
import dev.estebangperez.ticket.model.domain.TicketerVenue;
import dev.estebangperez.ticket.repository.TicketerVenueRepository;
import dev.estebangperez.ticket.service.BaseService;
import dev.estebangperez.ticket.service.TicketerVenueService;
import dev.estebangperez.ticket.util.mappers.TicketerVenueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TicketerVenueServiceImpl extends BaseService<TicketerVenue, Long> implements TicketerVenueService {

    private final TicketerVenueRepository venueRepository;

    @Override
    public Set<TicketerVenueDTO> findByCountry(String country) {
        return TicketerVenueMapper.mapVenuesFromEntityToDto(venueRepository.findByCountry(country));
    }

    @Override
    protected JpaRepository<TicketerVenue, Long> getRepository() {
        return venueRepository;
    }
}