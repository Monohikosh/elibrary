package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbercourses.library.model.Author;
import ru.sbercourses.library.service.GenericService;

@Slf4j
@RestController
@RequestMapping("/rest/author")
public class AuthorController extends GenericController<Author> {

    protected AuthorController(GenericService<Author> service) {
        super(service);
    }

}
