package dev.estebangperez.ticket.controller;

import dev.estebangperez.ticket.model.TicketerUserDTO;
import dev.estebangperez.ticket.util.TicketerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(TicketerApi.BASE_PATH + "user")
public interface TicketerUserApi {
    @PostMapping
    ResponseEntity<TicketerUserDTO> createUser(@RequestBody TicketerUserDTO userDTO);

    @GetMapping("/{id}")
    ResponseEntity<TicketerUserDTO> getUserById(@PathVariable Long id);

    @GetMapping("/search/{mail}")
    ResponseEntity<TicketerUserDTO> findUserByMail(@PathVariable String mail);

    @DeleteMapping
    ResponseEntity<Void> deleteUser(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<TicketerUserDTO>> listUsers();
}
