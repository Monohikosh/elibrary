package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sbercourses.library.model.User;
import ru.sbercourses.library.repository.GenericRepository;
import ru.sbercourses.library.service.GenericService;

@Slf4j
@RestController
@RequestMapping("/rest/user")
public class UserController extends GenericController<User> {

    protected UserController(GenericService<User> service) {
        super(service);
    }

}
