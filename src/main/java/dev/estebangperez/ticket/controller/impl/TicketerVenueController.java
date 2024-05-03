package dev.estebangperez.ticket.controller.impl;

import dev.estebangperez.ticket.controller.TicketerVenueApi;
import dev.estebangperez.ticket.model.TicketerVenueDTO;
import dev.estebangperez.ticket.service.impl.TicketerVenueServiceImpl;
import dev.estebangperez.ticket.util.mappers.TicketerVenueMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TicketerVenueController implements TicketerVenueApi {
    private final TicketerVenueServiceImpl ticketerVenueService;

    @Override
    public ResponseEntity<TicketerVenueDTO> createVenue(TicketerVenueDTO concertDTO) {
        return ResponseEntity.ok(TicketerVenueMapper.toDTO(ticketerVenueService.save(TicketerVenueMapper.fromDTO(concertDTO))));
    }

    @Override
    public ResponseEntity<TicketerVenueDTO> getVenueById(Long id) {
        return ticketerVenueService.findById(id)
                .map(performer -> ResponseEntity.ok(TicketerVenueMapper.toDTO(performer)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<TicketerVenueDTO>> getAllVenues() {
        List<TicketerVenueDTO> concerts = ticketerVenueService.findAll().stream()
                .map(TicketerVenueMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(concerts);
    }

    @Override
    public ResponseEntity<Void> deleteVenue(Long id) {
        ticketerVenueService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
