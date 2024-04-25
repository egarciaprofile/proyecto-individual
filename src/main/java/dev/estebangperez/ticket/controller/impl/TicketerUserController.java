package dev.estebangperez.ticket.controller.impl;

import dev.estebangperez.ticket.controller.TicketerConcertApi;
import dev.estebangperez.ticket.controller.TicketerUserApi;
import dev.estebangperez.ticket.model.TicketerUserDTO;
import dev.estebangperez.ticket.model.domain.TicketerUser;
import dev.estebangperez.ticket.service.impl.TicketerConcertServiceImpl;
import dev.estebangperez.ticket.service.impl.TicketerUserServiceImpl;
import dev.estebangperez.ticket.util.TicketerUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TicketerUserController implements TicketerUserApi {
    private final TicketerUserServiceImpl ticketerUserService;

    @Override
    public ResponseEntity<TicketerUserDTO> createUser(@RequestBody TicketerUserDTO userDTO) {
        TicketerUser user = TicketerUserMapper.fromDTO(userDTO);
        TicketerUserDTO savedUserDTO = TicketerUserMapper.toDTO(ticketerUserService.save(user));
        return ResponseEntity.ok(savedUserDTO);
    }

    @Override
    public ResponseEntity<TicketerUserDTO> getUserById(@PathVariable Long id) {
        return ticketerUserService.findById(id)
                .map(user -> ResponseEntity.ok(TicketerUserMapper.toDTO(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TicketerUserDTO> findUserByMail(@PathVariable String mail) {
        return ticketerUserService.findByEmail(mail)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        ticketerUserService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<TicketerUserDTO>> listUsers() {
        List<TicketerUserDTO> users = ticketerUserService.findAll().stream()
                .map(TicketerUserMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
}
