package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbercourses.library.dto.BookDto;
import ru.sbercourses.library.mapper.BookMapper;
import ru.sbercourses.library.model.Book;
import ru.sbercourses.library.model.Genre;
import ru.sbercourses.library.service.BookService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/book")
public class BookController extends GenericController<Book, BookDto> {

    private final BookService service;

    public BookController(BookService service, BookMapper mapper) {
        super(service, mapper);
        this.service = service;
    }

    @GetMapping("/search")
    public List<Book> search(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "genre", required = false) Genre genre
    ) {
        return service.search(title, genre);
    }

}
