package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sbercourses.library.model.Author;
import ru.sbercourses.library.repository.GenericRepository;

@Slf4j
@RestController
@RequestMapping("/rest/author")
public class AuthorController extends GenericController<Author> {

    protected AuthorController(GenericRepository<Author> genericRepository) {
        super(genericRepository);
    }

}
