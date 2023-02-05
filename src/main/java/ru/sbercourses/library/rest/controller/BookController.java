package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sbercourses.library.model.Book;
import ru.sbercourses.library.model.Genre;
import ru.sbercourses.library.repository.BookRepository;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/book")
public class BookController extends GenericController<Book> {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        super(bookRepository);
        this.bookRepository = bookRepository;
    }


    @GetMapping("/search")
    public List<Book> search(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "genre", required = false) Genre genre
    ) {
        return bookRepository.findAllByGenreOrTitle(
                genre,
                title
        );
    }

}
