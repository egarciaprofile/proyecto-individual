package dev.estebangperez.ticket.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
public class TicketerPerformerDTO {
    private Long id;
    private String name;
    private String genre;
    private Set<TicketerConcertDTO> concerts;
}