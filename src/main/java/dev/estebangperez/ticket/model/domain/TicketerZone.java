package dev.estebangperez.ticket.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketerZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    private TicketerVenue venue;

    @Column(nullable = false, length = 255)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "zone")
    private Set<TicketerSeat> seats;
}