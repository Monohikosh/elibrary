package ru.sbercourses.library.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends GenericDto {

    private Long id;
    private RoleDto role;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String address;

}
