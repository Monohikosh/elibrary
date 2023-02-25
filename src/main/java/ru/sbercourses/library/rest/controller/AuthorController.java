package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbercourses.library.dto.AuthorDto;
import ru.sbercourses.library.dto.AuthorWithBooksDto;
import ru.sbercourses.library.mapper.AuthorWithBooksMapper;
import ru.sbercourses.library.mapper.AuthorMapper;
import ru.sbercourses.library.model.Author;
import ru.sbercourses.library.service.AuthorService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/author")
public class AuthorController extends GenericController<Author, AuthorDto> {

    private final AuthorService service;
    private final AuthorWithBooksMapper authorWithBooksMapper;

    protected AuthorController(AuthorMapper mapper, AuthorService service, AuthorWithBooksMapper authorWithBooksMapper) {
        super(service, mapper);
        this.service = service;
        this.authorWithBooksMapper = authorWithBooksMapper;
    }

    @GetMapping("author-books")
    public List<AuthorWithBooksDto> getAuthorsWithBooks() {
        return service.listAll().stream().map(authorWithBooksMapper::toDto).toList();
    }
}
