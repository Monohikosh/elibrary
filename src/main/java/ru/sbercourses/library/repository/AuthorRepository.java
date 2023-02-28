package ru.sbercourses.library.repository;

import org.springframework.stereotype.Repository;
import ru.sbercourses.library.model.Author;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends GenericRepository<Author> {

    Set<Author> findAllByIdIn(Set<Long> ids);
    List<Author> findAllByAuthorFIO(String authorFIO);

}
