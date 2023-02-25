package ru.sbercourses.library.repository;

import org.springframework.stereotype.Repository;
import ru.sbercourses.library.model.Book;
import ru.sbercourses.library.model.Genre;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends GenericRepository<Book> {

    List<Book> findAllByGenreOrTitle(Genre genre, String title);
    Set<Book> findAllByIdIn(Set<Long> ids);

}