package dev.estebangperez.ticket.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketerTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private TicketerUser user;

    @ManyToOne
    @JoinColumn(name = "concert_id", nullable = false)
    private TicketerConcert concert;

    @OneToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private TicketerSeat seat;

    @Column(nullable = false)
    private LocalDateTime purchaseDate;
}