package ru.sbercourses.library.dto.utils;

import org.springframework.stereotype.Component;
import ru.sbercourses.library.dto.RoleDto;
import ru.sbercourses.library.model.Role;

@Component
public class RoleConverter extends Converter<Role, RoleDto> {

    public RoleConverter() {
        super(RoleConverter::convertToEntity, RoleConverter::convertToDto);
    }

    private static RoleDto convertToDto(Role role) {
        return new RoleDto(role.getId(), role.getTitle(), role.getDescription());
    }

    private static Role convertToEntity(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .title(roleDto.getTitle())
                .description(roleDto.getDescription())
                .build();
    }

}
