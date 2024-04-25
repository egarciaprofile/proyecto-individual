package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerPerformerDTO;
import dev.estebangperez.ticket.model.domain.TicketerPerformer;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketerPerformerMapper {
    public static TicketerPerformerDTO toDTO(TicketerPerformer performer) {
        return TicketerPerformerDTO.builder()
                .id(performer.getId())
                .name(performer.getName())
                .genre(performer.getGenre())
                .build();
    }

    public static TicketerPerformer fromDTO(TicketerPerformerDTO dto) {
        return TicketerPerformer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .genre(dto.getGenre())
                .build();
    }

    public static Set<TicketerPerformerDTO> mapPerformersFromEntityToDto(Set<TicketerPerformer> performers) {
        return performers.stream().map(TicketerPerformerMapper::toDTO).collect(Collectors.toSet());
    }

    public static Set<TicketerPerformer> mapPerformersFromDtoToEntity(List<TicketerPerformerDTO> performerDtos) {
        return performerDtos.stream().map(TicketerPerformerMapper::fromDTO).collect(Collectors.toSet());
    }
}