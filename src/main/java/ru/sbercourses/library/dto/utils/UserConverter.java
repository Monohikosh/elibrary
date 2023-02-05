package ru.sbercourses.library.dto.utils;

import org.springframework.stereotype.Component;
import ru.sbercourses.library.dto.RoleDto;
import ru.sbercourses.library.dto.UserDto;
import ru.sbercourses.library.model.Role;
import ru.sbercourses.library.model.User;

@Component
public class UserConverter extends Converter<User, UserDto> {


    public UserConverter() {
        super(UserConverter::convertToEntity, UserConverter::convertToDto);
    }

    private static UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .role(new RoleDto(user.getRole()))
                .login(user.getLogin())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .middleName(user.getMiddleName())
                .email(user.getEmail())
                .address(user.getAddress())
                .phone(user.getPhone())
                .build();
    }

    private static User convertToEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .role(new Role(userDto.getRole()))
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .firstName(userDto.getFirstName())
                .middleName(userDto.getMiddleName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .phone(userDto.getPhone())
                .build();
    }

}
