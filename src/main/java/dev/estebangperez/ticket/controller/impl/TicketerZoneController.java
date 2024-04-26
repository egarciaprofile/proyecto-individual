package dev.estebangperez.ticket.controller.impl;

import dev.estebangperez.ticket.controller.TicketerZoneApi;
import dev.estebangperez.ticket.model.TicketerZoneDTO;
import dev.estebangperez.ticket.service.TicketerZoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class TicketerZoneController implements TicketerZoneApi {

    private final TicketerZoneService ticketerZoneService;

    @Override
    public ResponseEntity<Set<TicketerZoneDTO>> getZonesByVenue(@PathVariable Long venueId) {
        return ResponseEntity.ok(ticketerZoneService.findAllByVenueId(venueId));
    }
}