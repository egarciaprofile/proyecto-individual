package dev.estebangperez.ticket.util.mappers;

import dev.estebangperez.ticket.model.TicketerUserDTO;
import dev.estebangperez.ticket.model.domain.TicketerUser;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TicketerUserMapper {
    public TicketerUserDTO toDTO(TicketerUser user) {
        return TicketerUserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public TicketerUser fromDTO(TicketerUserDTO dto) {
        return TicketerUser.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }

    public List<TicketerUserDTO> mapUsersFromEntityToDto(List<TicketerUser> users) {
        return users.stream().map(TicketerUserMapper::toDTO).collect(Collectors.toList());
    }

    public List<TicketerUser> mapUsersFromDtoToEntity(List<TicketerUserDTO> userDtos) {
        return userDtos.stream().map(TicketerUserMapper::fromDTO).collect(Collectors.toList());
    }
}