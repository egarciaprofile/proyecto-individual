package dev.estebangperez.ticket.controller;

import dev.estebangperez.ticket.model.TicketerEventDTO;
import dev.estebangperez.ticket.util.TicketerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(TicketerApi.BASE_PATH + "event")
public interface TicketerEventApi {
    @PostMapping
    ResponseEntity<TicketerEventDTO> createEvent(@RequestBody TicketerEventDTO concertDTO);

    @GetMapping("/{id}")
    ResponseEntity<TicketerEventDTO> getEventById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<TicketerEventDTO>> getAllEvents();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEvent(@PathVariable Long id);
}
