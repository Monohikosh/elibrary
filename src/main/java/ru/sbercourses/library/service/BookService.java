package ru.sbercourses.library.service;

import org.springframework.stereotype.Service;
import ru.sbercourses.library.model.Book;
import ru.sbercourses.library.model.Genre;
import ru.sbercourses.library.repository.BookRepository;
import ru.sbercourses.library.repository.GenericRepository;

import java.util.List;

@Service
public class BookService extends GenericService<Book> {

    private final BookRepository repository;

    protected BookService(BookRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Book> search(String title, Genre genre) {
        return repository.findAllByGenreOrTitle(
                genre,
                title
        );
    }
}
