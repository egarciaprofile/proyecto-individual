package dev.estebangperez.ticket.controller;

import dev.estebangperez.ticket.model.TicketerConcertDTO;
import dev.estebangperez.ticket.utils.TicketerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping(TicketerApi.BASE_PATH + "concert")
public interface TicketerConcertApi {

    @GetMapping(value = "/search/{performerName}")
    ResponseEntity<Set<TicketerConcertDTO>> getConcertByPerformerName(@PathVariable String performerName);

    @PostMapping
    ResponseEntity<TicketerConcertDTO> createConcert(@RequestBody TicketerConcertDTO concertDTO);

    @GetMapping("/{id}")
    ResponseEntity<TicketerConcertDTO> getConcertById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<TicketerConcertDTO>> getAllConcerts();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteConcert(@PathVariable Long id);
}
