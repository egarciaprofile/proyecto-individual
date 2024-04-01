package dev.estebangperez.ticket.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketerEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    private TicketerVenue venue;

    @Column(nullable = false)
    private LocalDateTime eventDate;

    @OneToMany(mappedBy = "event")
    private Set<TicketerConcert> concerts;

    @OneToMany(mappedBy = "event")
    private Set<TicketerSeat> seats;
}
