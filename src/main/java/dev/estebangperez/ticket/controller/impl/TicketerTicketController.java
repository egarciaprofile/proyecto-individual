package dev.estebangperez.ticket.controller.impl;

import dev.estebangperez.ticket.controller.TicketerTicketApi;
import dev.estebangperez.ticket.model.TicketerPerformerDTO;
import dev.estebangperez.ticket.model.TicketerTicketDTO;
import dev.estebangperez.ticket.service.impl.TicketerPerformerServiceImpl;
import dev.estebangperez.ticket.service.impl.TicketerTicketServiceImpl;
import dev.estebangperez.ticket.util.mappers.TicketerPerformerMapper;
import dev.estebangperez.ticket.util.mappers.TicketerTicketMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class TicketerTicketController implements TicketerTicketApi {
    private final TicketerTicketServiceImpl ticketerTicketService;

    @Override
    public ResponseEntity<TicketerTicketDTO> createTicket(TicketerTicketDTO concertDTO) {
        return ResponseEntity.ok(TicketerTicketMapper.toDTO(ticketerTicketService.save(TicketerTicketMapper.fromDTO(concertDTO))));
    }

    @Override
    public ResponseEntity<TicketerTicketDTO> getTicketById(Long id) {
        return ticketerTicketService.findById(id)
                .map(performer -> ResponseEntity.ok(TicketerTicketMapper.toDTO(performer)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Set<TicketerTicketDTO>> getAllTicketsByUserId(Long userId) {
        return ResponseEntity.ok(ticketerTicketService.findAllTicketsByUserId(userId));
    }

    @Override
    public ResponseEntity<Void> deleteTicket(Long id) {
        ticketerTicketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
