package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.domain.TicketerEvent;
import dev.estebangperez.ticket.repository.TicketerEventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TicketerEventServiceImplTest {

    @Mock
    private TicketerEventRepository ticketerEventRepository;

    @InjectMocks
    private TicketerEventService ticketerEventService;

    private TicketerEvent event, event1;

    @BeforeEach
    void setUp() {
        event = TicketerEvent.builder()
                .name("Sample Event")
                .eventDate(LocalDate.now().atStartOfDay())
                .build();

        event1 = TicketerEvent.builder()
                .name("Event 2")
                .eventDate(LocalDateTime.now().plusDays(1))
                .build();
    }

    @Test
    void findEventsByDate_ShouldReturnEvents() {
        LocalDate eventDate = LocalDate.now();
        given(ticketerEventRepository.findByEventDate(eventDate)).willReturn(Collections.singletonList(event));

        List<TicketerEvent> events = ticketerEventService.findByEventDate(eventDate.atStartOfDay().toLocalDate());

        assertEquals(1, events.size());
        TicketerEvent foundEvent = events.getFirst();
        assertEquals(event.getName(), foundEvent.getName());
        assertEquals(event.getEventDate(), foundEvent.getEventDate());
    }

    @Test
    void findAllBetweenDates_ShouldReturnEventsWithinTheSpecifiedDates() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(2);
        LocalDateTime endDate = LocalDateTime.now().plusDays(2);
        given(ticketerEventRepository.findAllBetweenDates(any(LocalDateTime.class), any(LocalDateTime.class)))
                .willReturn(Arrays.asList(event, event1));

        List<TicketerEvent> events = ticketerEventService.findAllBetweenDates(startDate, endDate);

        assertEquals(2, events.size());
        assertEquals(event.getName(), events.get(0).getName());
        assertEquals(event1.getName(), events.get(1).getName());

        assertTrue(events.stream().allMatch(event ->
                (event.getEventDate().isEqual(startDate) || event.getEventDate().isAfter(startDate)) &&
                        (event.getEventDate().isEqual(endDate) || event.getEventDate().isBefore(endDate))
        ));
    }
}