package dev.estebangperez.ticket.controller;

import dev.estebangperez.ticket.model.TicketerSeatDTO;
import dev.estebangperez.ticket.util.TicketerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping(TicketerApi.BASE_PATH + "seat")
public interface TicketerSeatApi {
    @GetMapping("/event/{eventId}")
    ResponseEntity<Set<TicketerSeatDTO>> findSeatsByEventId(@PathVariable Long eventId);
}
