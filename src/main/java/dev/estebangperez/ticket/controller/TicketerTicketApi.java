package dev.estebangperez.ticket.controller;

import dev.estebangperez.ticket.model.TicketerTicketDTO;
import dev.estebangperez.ticket.util.TicketerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping(TicketerApi.BASE_PATH + "ticket")
public interface TicketerTicketApi {
    @PostMapping
    ResponseEntity<TicketerTicketDTO> createTicket(@RequestBody TicketerTicketDTO concertDTO);

    @GetMapping("/{id}")
    ResponseEntity<TicketerTicketDTO> getTicketById(@PathVariable Long id);

    @GetMapping("/user/{userId}")
    ResponseEntity<Set<TicketerTicketDTO>> getAllTicketsByUserId(@PathVariable Long userId);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTicket(@PathVariable Long id);
}
