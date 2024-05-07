package dev.estebangperez.ticket.controller;

import dev.estebangperez.ticket.model.TicketerVenueDTO;
import dev.estebangperez.ticket.util.TicketerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(TicketerApi.BASE_PATH + "venue")
public interface TicketerVenueApi {
    @PostMapping
    ResponseEntity<TicketerVenueDTO> createVenue(@RequestBody TicketerVenueDTO concertDTO);

    @GetMapping("/{id}")
    ResponseEntity<TicketerVenueDTO> getVenueById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<TicketerVenueDTO>> getAllVenues();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteVenue(@PathVariable Long id);
}
