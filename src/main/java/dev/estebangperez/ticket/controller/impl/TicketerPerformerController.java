package dev.estebangperez.ticket.controller.impl;

import dev.estebangperez.ticket.controller.TicketerPerformerApi;
import dev.estebangperez.ticket.model.TicketerPerformerDTO;
import dev.estebangperez.ticket.service.impl.TicketerPerformerServiceImpl;
import dev.estebangperez.ticket.util.mappers.TicketerPerformerMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TicketerPerformerController implements TicketerPerformerApi {
    private final TicketerPerformerServiceImpl ticketerPerformerService;


    @Override
    public ResponseEntity<TicketerPerformerDTO> createPerformer(TicketerPerformerDTO concertDTO) {
        return ResponseEntity.ok(TicketerPerformerMapper.toDTO(ticketerPerformerService.save(TicketerPerformerMapper.fromDTO(concertDTO))));
    }

    @Override
    public ResponseEntity<TicketerPerformerDTO> getPerformerById(Long id) {
        return ticketerPerformerService.findById(id)
                .map(performer -> ResponseEntity.ok(TicketerPerformerMapper.toDTO(performer)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<TicketerPerformerDTO>> getAllPerformers() {
        List<TicketerPerformerDTO> concerts = ticketerPerformerService.findAll().stream()
                .map(TicketerPerformerMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(concerts);
    }

    @Override
    public ResponseEntity<Void> deletePerformer(Long id) {
        ticketerPerformerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
