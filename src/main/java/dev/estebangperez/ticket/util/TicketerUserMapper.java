package dev.estebangperez.ticket.util;

import dev.estebangperez.ticket.model.TicketerUserDTO;
import dev.estebangperez.ticket.model.domain.TicketerUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketerUserMapper {
    public static TicketerUserDTO toDTO(TicketerUser user) {
        return TicketerUserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .tickets(TicketerTicketMapper.mapTicketsFromEntityToDtoId(user.getTickets()))
                .build();
    }

    public static TicketerUser fromDTO(TicketerUserDTO dto) {
        return TicketerUser.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                //.tickets(TicketerTicketMapper.mapTicketsFromDtoToEntity(dto.getTickets()))
                .build();
    }

    public static List<TicketerUserDTO> mapUsersFromEntityToDto(List<TicketerUser> users) {
        return users.stream().map(TicketerUserMapper::toDTO).collect(Collectors.toList());
    }

    public static List<TicketerUser> mapUsersFromDtoToEntity(List<TicketerUserDTO> userDtos) {
        return userDtos.stream().map(TicketerUserMapper::fromDTO).collect(Collectors.toList());
    }
}