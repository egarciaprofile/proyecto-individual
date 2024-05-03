package dev.estebangperez.ticket.controller;

import dev.estebangperez.ticket.model.TicketerPerformerDTO;
import dev.estebangperez.ticket.utils.TicketerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(TicketerApi.BASE_PATH + "performer")
public interface TicketerPerformerApi {
    @PostMapping
    ResponseEntity<TicketerPerformerDTO> createPerformer(@RequestBody TicketerPerformerDTO concertDTO);

    @GetMapping("/{id}")
    ResponseEntity<TicketerPerformerDTO> getPerformerById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<TicketerPerformerDTO>> getAllPerformers();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePerformer(@PathVariable Long id);
}
