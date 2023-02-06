package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbercourses.library.model.Book;
import ru.sbercourses.library.model.Genre;
import ru.sbercourses.library.service.BookService;
import ru.sbercourses.library.service.GenericService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/book")
public class BookController extends GenericController<Book> {

    private final BookService service;

    public BookController(GenericService<Book> service, BookService service1) {
        super(service);
        this.service = service1;
    }

    @GetMapping("/search")
    public List<Book> search(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "genre", required = false) Genre genre
    ) {
        return service.search(title, genre);
    }

}
