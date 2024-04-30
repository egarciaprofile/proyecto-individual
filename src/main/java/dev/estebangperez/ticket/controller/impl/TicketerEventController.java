package dev.estebangperez.ticket.controller.impl;

import dev.estebangperez.ticket.controller.TicketerEventApi;
import dev.estebangperez.ticket.model.TicketerEventDTO;
import dev.estebangperez.ticket.service.impl.TicketerEventServiceImpl;
import dev.estebangperez.ticket.util.mappers.TicketerEventMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TicketerEventController implements TicketerEventApi {
    private final TicketerEventServiceImpl ticketerEventService;

    @Override
    public ResponseEntity<TicketerEventDTO> createEvent(TicketerEventDTO concertDTO) {
        return ResponseEntity.ok(TicketerEventMapper.toDTO(ticketerEventService.save(TicketerEventMapper.fromDTO(concertDTO))));
    }

    @Override
    public ResponseEntity<TicketerEventDTO> getEventById(Long id) {
        return ticketerEventService.findById(id)
                .map(event -> ResponseEntity.ok(TicketerEventMapper.toDTO(event)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<TicketerEventDTO>> getAllEvents() {
        List<TicketerEventDTO> concerts = ticketerEventService.findAll().stream()
                .map(TicketerEventMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(concerts);
    }

    @Override
    public ResponseEntity<Void> deleteEvent(Long id) {
        ticketerEventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
