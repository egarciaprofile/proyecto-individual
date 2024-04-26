package dev.estebangperez.ticket.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketerPerformerDTO {
    private Long id;
    private String name;
    private String genre;
}