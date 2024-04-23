package dev.estebangperez.ticket.controller;

import dev.estebangperez.ticket.model.TicketerZoneDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping(value = "/zone")
public interface TicketerZoneApi {
    @GetMapping("/{venueId}")
    ResponseEntity<Set<TicketerZoneDTO>> getZonesByVenue(@PathVariable Long venueId);
}
