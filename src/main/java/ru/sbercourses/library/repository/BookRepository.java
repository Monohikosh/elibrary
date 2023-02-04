package ru.sbercourses.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbercourses.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
