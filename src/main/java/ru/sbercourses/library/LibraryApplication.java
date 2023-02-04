package ru.sbercourses.library;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sbercourses.library.dto.RoleDto;
import ru.sbercourses.library.dto.UserDto;
import ru.sbercourses.library.dto.utils.Converter;
import ru.sbercourses.library.model.Role;
import ru.sbercourses.library.model.User;
import ru.sbercourses.library.repository.UserRepository;

import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        log.info("Swagger-ui run on: http://localhost:9090/swagger-ui/index.html");
    }

}
