package dev.estebangperez.ticket.controller.impl;

import dev.estebangperez.ticket.controller.TicketerConcertApi;
import dev.estebangperez.ticket.model.TicketerConcertDTO;
import dev.estebangperez.ticket.model.domain.TicketerConcert;
import dev.estebangperez.ticket.service.impl.TicketerConcertServiceImpl;
import dev.estebangperez.ticket.util.TicketerConcertMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TicketerConcertController implements TicketerConcertApi {
    private final TicketerConcertServiceImpl ticketerConcertService;

    @Override
    public ResponseEntity<Set<TicketerConcertDTO>> getConcertByPerformerName(@PathVariable String performerName) {
        Set<TicketerConcertDTO> concerts = ticketerConcertService.findByPerformerNameContainingIgnoreCase(performerName);
        return ResponseEntity.ok(concerts);
    }
    @Override
    public ResponseEntity<TicketerConcertDTO> createConcert(@RequestBody TicketerConcertDTO concertDTO) {
        TicketerConcert concert = TicketerConcertMapper.fromDTO(concertDTO);
        TicketerConcertDTO savedConcertDTO = TicketerConcertMapper.toDTO(ticketerConcertService.save(concert));
        return ResponseEntity.ok(savedConcertDTO);
    }
    @Override
    public ResponseEntity<TicketerConcertDTO> getConcertById(@PathVariable Long id) {
        return ticketerConcertService.findById(id)
                .map(concert -> ResponseEntity.ok(TicketerConcertMapper.toDTO(concert)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<TicketerConcertDTO>> getAllConcerts() {
        List<TicketerConcertDTO> concerts = ticketerConcertService.findAll().stream()
                .map(TicketerConcertMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(concerts);
    }

    @Override
    public ResponseEntity<Void> deleteConcert(@PathVariable Long id) {
        ticketerConcertService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
