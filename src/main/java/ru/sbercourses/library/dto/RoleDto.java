package ru.sbercourses.library.dto;

import lombok.*;
import ru.sbercourses.library.model.Role;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class RoleDto {

    private Long id;
    private String title;
    private String description;

    public RoleDto(Role role) {
        this.id = role.getId();
        this.title = role.getTitle();
        this.description = role.getDescription();
    }
}
