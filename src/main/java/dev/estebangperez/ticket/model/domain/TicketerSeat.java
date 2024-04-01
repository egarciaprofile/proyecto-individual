package dev.estebangperez.ticket.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketerSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private TicketerEvent event;

    @ManyToOne
    @JoinColumn(name = "zone_id", nullable = false)
    private TicketerZone zone;

    @OneToOne(mappedBy = "seat")
    private TicketerTicket ticket;
}