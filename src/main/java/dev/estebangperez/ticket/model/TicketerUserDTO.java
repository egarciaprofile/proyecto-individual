package dev.estebangperez.ticket.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
public class TicketerUserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private Set<TicketerTicketDTO> tickets;
}

