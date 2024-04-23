package dev.estebangperez.ticket.controller;

import dev.estebangperez.ticket.model.TicketerUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/user")
public interface TicketerUserApi {
    @PostMapping("/")
    TicketerUserDTO createUser(@RequestBody TicketerUserDTO userDTO);

    @GetMapping("/{id}")
    ResponseEntity<TicketerUserDTO> getUserById(@PathVariable Long id);

    @GetMapping("/search/{mail}")
    ResponseEntity<TicketerUserDTO> findUserByMail(@PathVariable String mail);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id);

    @GetMapping("/")
    List<TicketerUserDTO> listUsers();
}
