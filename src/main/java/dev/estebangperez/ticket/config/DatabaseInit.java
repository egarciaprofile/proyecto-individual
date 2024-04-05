package dev.estebangperez.ticket.config;

import dev.estebangperez.ticket.model.domain.*;
import dev.estebangperez.ticket.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Component
public class DatabaseInit {

    private final TicketerEventRepository eventRepository;
    private final TicketerPerformerRepository performerRepository;
    private final TicketerVenueRepository venueRepository;
    private final TicketerZoneRepository zoneRepository;
    private final TicketerConcertRepository concertRepository;
    private final TicketerSeatRepository seatRepository;
    private final TicketerTicketRepository ticketRepository;
    private final TicketerUserRepository userRepository;

    public DatabaseInit(TicketerEventRepository eventRepository,
                           TicketerPerformerRepository performerRepository,
                           TicketerVenueRepository venueRepository,
                           TicketerZoneRepository zoneRepository,
                           TicketerConcertRepository concertRepository,
                           TicketerSeatRepository seatRepository,
                           TicketerTicketRepository ticketRepository,
                           TicketerUserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.performerRepository = performerRepository;
        this.venueRepository = venueRepository;
        this.zoneRepository = zoneRepository;
        this.concertRepository = concertRepository;
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initExampleData() {
        if (!isDatabaseEmpty()) {
            return;
        }

        log.warn("DatabaseInit#initExampleData called, adding example data to database");

        TicketerVenue venue = venueRepository.save(TicketerVenue.builder()
                .name("Concert Hall")
                .location("123 Main St")
                .capacity(1000)
                .build());

        TicketerZone zone = zoneRepository.save(TicketerZone.builder()
                .venue(venue)
                .name("Front Stage")
                .description("Close to the action!")
                .price(new BigDecimal("99.99"))
                .build());

        TicketerEvent event = eventRepository.save(TicketerEvent.builder()
                .name("The Big Concert")
                .venue(venue)
                .eventDate(LocalDateTime.now().plusMonths(1))
                .build());

        TicketerPerformer performer = performerRepository.save(TicketerPerformer.builder()
                .name("The Rockers")
                .genre("Rock")
                .build());

        TicketerConcert concert = concertRepository.save(TicketerConcert.builder()
                .event(event)
                .performer(performer)
                .build());

        TicketerSeat seat = seatRepository.save(TicketerSeat.builder()
                .event(event)
                .zone(zone)
                .build());

        TicketerUser user = userRepository.save(TicketerUser.builder()
                .name("John")
                .surname("Doe")
                .email("john.doe@example.com")
                .password("password")
                .phone("1234567890")
                .build());

        TicketerTicket ticket = ticketRepository.save(TicketerTicket.builder()
                .user(user)
                .concert(concert)
                .seat(seat)
                .purchaseDate(LocalDateTime.now())
                .build());
    }

    private boolean isDatabaseEmpty() {
        return venueRepository.count() == 0 && eventRepository.count() == 0
                && performerRepository.count() == 0 && zoneRepository.count() == 0
                && concertRepository.count() == 0 && seatRepository.count() == 0
                && ticketRepository.count() == 0 && userRepository.count() == 0;
    }
}
