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
    public Set<TicketerConcertDTO> getConcertByPerformerName(@PathVariable String performerName) {
        return ticketerConcertService.findByPerformerNameContainingIgnoreCase(performerName);
    }

    @Override
    public TicketerConcertDTO createConcert(@RequestBody TicketerConcertDTO concertDTO) {
        TicketerConcert concert = TicketerConcertMapper.fromDTO(concertDTO);
        return TicketerConcertMapper.toDTO(ticketerConcertService.save(concert));
    }

    @Override
    public ResponseEntity<TicketerConcertDTO> getConcertById(@PathVariable Long id) {
        return ticketerConcertService.findById(id)
                .map(concert -> ResponseEntity.ok(TicketerConcertMapper.toDTO(concert)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public List<TicketerConcertDTO> getAllConcerts() {
        return ticketerConcertService.findAll().stream()
                .map(TicketerConcertMapper::
                        toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Void> deleteConcert(@PathVariable Long id) {
        ticketerConcertService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
