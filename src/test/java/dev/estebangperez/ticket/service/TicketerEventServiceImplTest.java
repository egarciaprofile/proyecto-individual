package dev.estebangperez.ticket.service;

import dev.estebangperez.ticket.model.TicketerEventDTO;
import dev.estebangperez.ticket.model.domain.TicketerEvent;
import dev.estebangperez.ticket.repository.TicketerEventRepository;
import dev.estebangperez.ticket.service.impl.TicketerEventServiceImpl;
import dev.estebangperez.ticket.util.TicketerEventMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketerEventServiceImplTest {

    @Mock
    private TicketerEventRepository ticketerEventRepository;

    @Mock
    private TicketerEventMapper ticketerEventMapper;

    @InjectMocks
    private TicketerEventServiceImpl ticketerEventService;

    private TicketerEvent event, event1;

    @BeforeEach
    void setUp() {
        event = TicketerEvent.builder()
                .id(1L)
                .name("Sample Event")
                .eventDate(LocalDate.now().atStartOfDay())
                .seats(new HashSet<>())
                .concerts(new HashSet<>())
                .build();


        event1 = TicketerEvent.builder()
                .id(2L)
                .name("Event 2")
                .eventDate(LocalDateTime.now().plusDays(1))
                .seats(new HashSet<>())
                .concerts(new HashSet<>())
                .build();
    }

    @Test
    void findEventsByDate_ShouldReturnEvents() {
        LocalDate eventDate = LocalDate.now();
        given(ticketerEventRepository.findByEventDate(eventDate)).willReturn(new HashSet<>(Collections.singletonList(event)));

        Set<TicketerEventDTO> events = ticketerEventService.findByEventDate(eventDate.atStartOfDay().toLocalDate());

        assertEquals(1, events.size());
        //assertTrue(events.contains(TicketerEventMapper.toDTO(event)));
    }

    @Test
    void findAllBetweenDates_ShouldReturnEventsWithinTheSpecifiedDates() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(2);
        LocalDateTime endDate = LocalDateTime.now().plusDays(2);
        given(ticketerEventRepository.findAllBetweenDates(any(LocalDateTime.class), any(LocalDateTime.class)))
                .willReturn(new HashSet<>(Arrays.asList(event, event1)));

        Set<TicketerEventDTO> events = ticketerEventService.findAllBetweenDates(startDate, endDate);

        assertEquals(2, events.size());
        Object[] myArr = events.toArray();

        assertEquals(event.getName(), ((TicketerEventDTO)myArr[0]).getName());
        assertEquals(event1.getName(), ((TicketerEventDTO)myArr[1]).getName());

        assertTrue(events.stream().allMatch(eventDTO ->
                (eventDTO.getEventDate().isEqual(startDate) || eventDTO.getEventDate().isAfter(startDate)) &&
                        (eventDTO.getEventDate().isEqual(endDate) || eventDTO.getEventDate().isBefore(endDate))
        ));
    }
}