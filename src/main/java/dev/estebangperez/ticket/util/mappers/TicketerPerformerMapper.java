package dev.estebangperez.ticket.util.mappers;

import dev.estebangperez.ticket.model.TicketerPerformerDTO;
import dev.estebangperez.ticket.model.domain.TicketerPerformer;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class TicketerPerformerMapper {
    public TicketerPerformerDTO toDTO(TicketerPerformer performer) {
        return TicketerPerformerDTO.builder()
                .id(performer.getId())
                .name(performer.getName())
                .genre(performer.getGenre())
                .build();
    }

    public TicketerPerformer fromDTO(TicketerPerformerDTO dto) {
        return TicketerPerformer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .genre(dto.getGenre())
                .build();
    }

    public Set<TicketerPerformerDTO> mapPerformersFromEntityToDto(Set<TicketerPerformer> performers) {
        return performers.stream().map(TicketerPerformerMapper::toDTO).collect(Collectors.toSet());
    }

    public Set<TicketerPerformer> mapPerformersFromDtoToEntity(List<TicketerPerformerDTO> performerDtos) {
        return performerDtos.stream().map(TicketerPerformerMapper::fromDTO).collect(Collectors.toSet());
    }
}