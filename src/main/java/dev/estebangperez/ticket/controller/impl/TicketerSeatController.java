package dev.estebangperez.ticket.controller.impl;

import dev.estebangperez.ticket.controller.TicketerSeatApi;
import dev.estebangperez.ticket.model.TicketerSeatDTO;
import dev.estebangperez.ticket.service.impl.TicketerSeatServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class TicketerSeatController implements TicketerSeatApi {
    private final TicketerSeatServiceImpl ticketerSeatService;

    @Override
    public ResponseEntity<Set<TicketerSeatDTO>> findSeatsByEventId(Long eventId) {
        return ResponseEntity.ok(ticketerSeatService.findSeatsByEventId(eventId));
    }
}
