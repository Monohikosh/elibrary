package ru.sbercourses.library.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sbercourses.library.dto.UserDto;
import ru.sbercourses.library.mapper.GenericMapper;
import ru.sbercourses.library.model.User;

@Component
public class UserMapper extends GenericMapper<User, UserDto> {

    protected UserMapper(ModelMapper mapper) {
        super(mapper, User.class, UserDto.class);
    }
}
