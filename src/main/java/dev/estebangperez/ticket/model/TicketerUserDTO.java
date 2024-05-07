package dev.estebangperez.ticket.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TicketerUserDTO {
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phone;
    private List<Long> tickets;
}

