package dev.estebangperez.ticket.util.mappers;

import dev.estebangperez.ticket.model.TicketerVenueDTO;
import dev.estebangperez.ticket.model.domain.TicketerVenue;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class TicketerVenueMapper {
    public TicketerVenueDTO toDTO(TicketerVenue venue) {
        return TicketerVenueDTO.builder()
                .id(venue.getId())
                .name(venue.getName())
                .city(venue.getCity())
                .country(venue.getCountry())
                .address(venue.getAddress())
                .capacity(venue.getCapacity())
                .build();
    }

    public TicketerVenue fromDTO(TicketerVenueDTO dto) {
        return TicketerVenue.builder()
                .id(dto.getId())
                .name(dto.getName())
                .city(dto.getCity())
                .country(dto.getCountry())
                .address(dto.getAddress())
                .capacity(dto.getCapacity())
                .build();
    }

    public Set<TicketerVenueDTO> mapVenuesFromEntityToDto(Set<TicketerVenue> venues) {
        return venues.stream().map(TicketerVenueMapper::toDTO).collect(Collectors.toSet());
    }

    public Set<TicketerVenue> mapVenuesFromDtoToEntity(Set<TicketerVenueDTO> venueDtos) {
        return venueDtos.stream().map(TicketerVenueMapper::fromDTO).collect(Collectors.toSet());
    }
}